package com.flightbooking.controllers;

import com.flightbooking.dtos.BookingDTO;
import com.flightbooking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> saveBooking(@RequestBody BookingDTO dto){
        bookingService.saveBooking(dto);
        return ResponseEntity.ok().body("Booking saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listAll(Optional<Integer> userid){
        if(userid.isPresent()){
            return ResponseEntity.ok(bookingService.userbookings(userid.get()));
        }
        return ResponseEntity.ok(bookingService.allBookings());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id){
        return ResponseEntity.ok(bookingService.findById(id));
    }

    @GetMapping("cancel/{id}")
    public ResponseEntity<?> cancelbooking(@PathVariable("id") int id){
        bookingService.cancelBooking(id);
        return ResponseEntity.ok().body("Booking cancelled successfully");
    }
}
