package com.flightbooking.services;

import com.flightbooking.dtos.BookingDTO;
import com.flightbooking.models.Booking;
import com.flightbooking.models.Flight;
import com.flightbooking.models.FlightStatus;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.FlightStatusRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired private BookingRepository repo;
@Autowired private UserService userService;
@Autowired private PassengerService passengerService;
@Autowired private FlightService flightService;
@Autowired private FlightStatusRepository fsrepo;
    public void saveBooking(BookingDTO dto){
        Booking booking=new Booking();
        BeanUtils.copyProperties(dto,booking);
        booking.setBookedBy(userService.findByUserId(dto.getUserid()));
        Flight flight=flightService.findById(dto.getFlightid());
        booking.setFlight(flight);
        booking.setPassenger(passengerService.findById(dto.getPassengerid()));
        repo.save(booking);
        FlightStatus fs=flight.getFlightStatus();
        switch(dto.getSeatType()){
            case "Economy Seat":
                fs.setRemainingEconomySeats(fs.getRemainingEconomySeats()-dto.getNoOfSeats());
                break;
            case "Business Seat":
                fs.setRemainingBuinessSeats(fs.getRemainingBuinessSeats()-dto.getNoOfSeats());
                break;
            case "Premium Seat":
                fs.setRemainingPremiumSeats(fs.getRemainingPremiumSeats()-dto.getNoOfSeats());
                break;
        }
        fsrepo.save(fs);
    }

    public Booking findById(int id){
        return repo.getById(id);
    }

    public List<Booking> allBookings(){
        return repo.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    public List<Booking> userbookings(int id){
        return repo.findByBookedByOrderByIdDesc(userService.findByUserId(id));
    }

    public void cancelBooking(int id){
        Booking bk=repo.getById(id);
        bk.setStatus("Cancelled");
        repo.save(bk);
        FlightStatus fs=bk.getFlight().getFlightStatus();
        switch(bk.getSeatType()){
            case "Economy Seat":
                fs.setRemainingEconomySeats(fs.getRemainingEconomySeats()+bk.getNoOfSeats());
                break;
            case "Business Seat":
                fs.setRemainingBuinessSeats(fs.getRemainingBuinessSeats()+bk.getNoOfSeats());
                break;
            case "Premium Seat":
                fs.setRemainingPremiumSeats(fs.getRemainingPremiumSeats()+bk.getNoOfSeats());
                break;
        }
        fsrepo.save(fs);
    }
}
