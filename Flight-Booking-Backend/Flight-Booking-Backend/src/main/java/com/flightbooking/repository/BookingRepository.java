package com.flightbooking.repository;

import com.flightbooking.models.Booking;
import com.flightbooking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    List<Booking> findByBookedByOrderByIdDesc(User user);
}
