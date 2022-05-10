package com.flightbooking.repository;

import com.flightbooking.models.Passenger;
import com.flightbooking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
    List<Passenger> findByCreatedBy(User user);
}
