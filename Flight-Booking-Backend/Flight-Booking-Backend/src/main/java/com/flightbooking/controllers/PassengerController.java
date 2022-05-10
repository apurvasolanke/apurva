package com.flightbooking.controllers;

import com.flightbooking.dtos.PassengerDTO;
import com.flightbooking.models.Location;
import com.flightbooking.models.Passenger;
import com.flightbooking.services.LocationService;
import com.flightbooking.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @PostMapping
    public ResponseEntity<?> savePassenger(@RequestBody PassengerDTO dto){
        passengerService.savePassenger(dto);
        return ResponseEntity.ok().body("Passenger saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listallPassengers(Optional<Integer> userid){
        return ResponseEntity.ok(passengerService.userPassengers(userid.get()));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findPassenger(@PathVariable("id")int id){
        return ResponseEntity.ok(passengerService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePassenger(@PathVariable("id") int id){
        passengerService.deletePassenger(id);
        return ResponseEntity.ok().body("Passenger deleted successfully");
    }
}
