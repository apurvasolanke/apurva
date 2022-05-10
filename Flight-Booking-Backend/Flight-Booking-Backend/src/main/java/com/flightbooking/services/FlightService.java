package com.flightbooking.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.dtos.FlightDTO;
import com.flightbooking.dtos.SearchDTO;
import com.flightbooking.models.Fare;
import com.flightbooking.models.Fleet;
import com.flightbooking.models.Flight;
import com.flightbooking.models.FlightStatus;
import com.flightbooking.repository.FareRepository;
import com.flightbooking.repository.FleetRepository;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.repository.FlightStatusRepository;

@Service
public class FlightService {
    @Autowired private FleetRepository fleetrepo;
    @Autowired private FareRepository fareerepo;
    @Autowired private FlightStatusRepository fsrepo;
    @Autowired private FlightRepository repo;
    @Autowired private LocationService locationService;

    public void saveFlight(FlightDTO dto){
        Flight flight=new Flight();
        BeanUtils.copyProperties(dto,flight);
        flight.setArrivalLocation(locationService.findById(dto.getArrivalLocationId()));
        flight.setDepartureLocation(locationService.findById(dto.getDepartureLocationId()));

        Fare fare=fareerepo.saveAndFlush(flight.getFare());
        flight.setFare(fare);

        Fleet fleet=fleetrepo.getById(dto.getFleetId());
        flight.setFleet(fleet);

        FlightStatus flightStatus=new FlightStatus();
        flightStatus.setRemainingBuinessSeats(fleet.getTotalBuinessSeats());
        flightStatus.setRemainingEconomySeats(fleet.getTotalEconomySeats());
        flightStatus.setRemainingPremiumSeats(fleet.getTotalPremiumSeats());
        FlightStatus flightStatusupdated=fsrepo.saveAndFlush(flightStatus);
        flight.setFlightStatus(flightStatusupdated);

        repo.save(flight);
    }

    public List<Flight> allFlights(){
        return repo.findAll();
    }

    public List<Flight> todayFlights(){
        return repo.findByFlightDate(LocalDate.now());
    }

    public List<Flight> searchFlights(SearchDTO dto){
        if(dto.getFlightDate()!=null)
            return repo.findFlights(dto.getFromlocation(),dto.getTolocation(),dto.getFlightDate());
        else
            return repo.findFlights(dto.getFromlocation(),dto.getTolocation());
    }

    public Flight findById(int id){
    	Optional<Flight> flight=repo.findById(id);
    	if(flight.isPresent())
    		return flight.get();
        return null;
    }

    public void deleteFlight(int id){
        repo.delete(repo.getById(id));
    }
}
