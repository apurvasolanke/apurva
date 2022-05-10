package com.flightbooking.repository;

import com.flightbooking.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {
    @Query(value="select * from flight where arrival_location_id=?1 and departure_location_id=?2 and flightDate=?3",nativeQuery = true)
    List<Flight> findFlights(int fromlocation, int tolocation, LocalDate fromdate);

    @Query(value="select * from flight where arrival_location_id=?1 and departure_location_id=?2 and flightDate>=date(now())",nativeQuery = true)
    List<Flight> findFlights(int fromlocation, int tolocation);

    List<Flight> findByFlightDate(LocalDate date);
}
