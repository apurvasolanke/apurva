import axios from 'axios'
import { format, parse } from 'date-fns'
import { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import Swal from 'sweetalert2'

export default function Booknow() {
  const { id } = useParams()
  const userid = sessionStorage.getItem('id')
  const [flight, setflight] = useState({})
  const [passengerid, setpassengerid] = useState()
  const [cost, setcost] = useState()
  const [seattype, setseattype] = useState()
  const [noofseat, setnoofseats] = useState(1)
  const [passengers, setpassengers] = useState([])
  const updateseat = (seats) => {
    setseattype(seats)
  }
  const updatenoofseat = (seats) => {
    setnoofseats(seats)
  }
  const handleSubmit = (e) => {
    e.preventDefault()
    axios
      .post('http://localhost:8080/api/bookings', {
        flightid: flight?.id,
        userid: userid,
        passengerid: passengerid,
        totalCost: cost,
        noOfSeats: noofseat,
        seatType: seattype,
        travelDate: flight.flightDate,
      })
      .then((resp) => {
        Swal.fire({ title: 'Success', text: resp.data })
      })
  }
  useEffect(() => {
    switch (seattype) {
      case 'Business Seat':
        setcost((value) => noofseat * flight?.fare?.businessFare)
        break
      case 'Premium Seat':
        setcost((value) => noofseat * flight?.fare?.premiumFare)
        break
      case 'Economy Seat':
        setcost((value) => noofseat * flight?.fare?.economyFare)
        break
    }
  }, [seattype, noofseat])
  useEffect(() => {
    axios
      .get('http://localhost:8080/api/passengers?userid=' + userid)
      .then((resp) => {
        setpassengers(resp.data)
      })
      .catch((err) => {
        console.log(err)
      })
    axios
      .get('http://localhost:8080/api/flights/' + id)
      .then((resp) => {
        setflight(resp.data)
      })
      .catch((err) => {
        console.log(err)
      })
  }, [])
  return (
    <>
      <div className='container mt-5'>
        <h4>Booking flight no {id}</h4>
        <div className='row'>
          <div className='col-sm-4 mx-auto'>
            <form>
              <div className='mb-2'>
                <label>Flight No</label>
                <input
                  type='text'
                  disabled
                  value={id}
                  className='form-control'
                />
              </div>
              <div className='mb-2'>
                <label>Select Date</label>
                <input
                  type='text'
                  value={flight?.flightDate}
                  disabled
                  className='form-control'
                />
              </div>
              <div className='mb-2'>
                <label>Select Seat Type</label>
                <select
                  value={seattype}
                  onChange={(e) => updateseat(e.target.value)}
                  className='form-control'
                >
                  <option value=''>Select Seat</option>
                  <option value='Business Seat'>
                    Business Seat - &#8377;{flight?.fare?.businessFare} -
                    {flight?.flightStatus?.remainingBuinessSeats} Seats
                  </option>
                  <option value='Premium Seat'>
                    Premium Seat - &#8377;{flight?.fare?.premiumFare} -
                    {flight?.flightStatus?.remainingPremiumSeats} Seats
                  </option>
                  <option value='Economy Seat'>
                    Economy Seat - &#8377;{flight?.fare?.economyFare} -
                    {flight?.flightStatus?.remainingEconomySeats} Seats
                  </option>
                </select>
              </div>
              <div className='mb-2'>
                <label>No Of Seats</label>
                <input
                  type='number'
                  min={1}
                  value={noofseat}
                  onChange={(e) => updatenoofseat(e.target.value)}
                  className='form-control'
                />
              </div>
              <div className='mb-2'>
                <label>Passenger</label>
                <select
                  value={passengerid}
                  onChange={(e) => setpassengerid(e.target.value)}
                  className='form-control'
                >
                  <option value=''>Select Passenger</option>
                  {passengers.map((x) => (
                    <option value={x.id}>
                      {x.firstName} {x.lastName} - {x.passportNo}
                    </option>
                  ))}
                </select>
              </div>
              <div className='mb-2'>
                <label>Total Cost</label>
                <input
                  type='text'
                  disabled
                  value={cost}
                  className='form-control'
                />
              </div>
              <button
                onClick={handleSubmit}
                className='btn btn-primary float-end'
              >
                Book Now
              </button>
            </form>
          </div>
        </div>
      </div>
    </>
  )
}
