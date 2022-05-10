package com.flightbooking.controllers;

import com.flightbooking.dtos.FlightDTO;
import com.flightbooking.dtos.SearchDTO;
import com.flightbooking.models.Fleet;
import com.flightbooking.models.Flight;
import com.flightbooking.services.FleetService;
import com.flightbooking.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<?> saveFlight(@RequestBody FlightDTO dto){
    	Flight flight=flightService.findById(dto.getId());
    	System.out.println(flight);
        if(flight!=null){
            return ResponseEntity.badRequest().body("Flight already exists");
        }
        flightService.saveFlight(dto);
        return ResponseEntity.ok().body("Flight saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> allflights(){
        return ResponseEntity.ok(flightService.allFlights());
    }

    @GetMapping("todays")
    public ResponseEntity<?> todayflights(){
        return ResponseEntity.ok(flightService.todayFlights());
    }

    @GetMapping("search")
    public ResponseEntity<?> searchflights(SearchDTO dto){
        System.out.println(dto);
        return ResponseEntity.ok(flightService.searchFlights(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findFlight(@PathVariable("id")int id){
        return ResponseEntity.ok(flightService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable("id") int id){
        flightService.deleteFlight(id);
        return ResponseEntity.ok().body("Flight deleted successfully");
    }
}
