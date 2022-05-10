package com.flightbooking.controllers;

import com.flightbooking.models.Fleet;
import com.flightbooking.models.Location;
import com.flightbooking.services.FleetService;
import com.flightbooking.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/fleets")
public class FleetController {

    @Autowired
    private FleetService fleetService;

    @PostMapping
    public ResponseEntity<?> saveFleet(@RequestBody Fleet fleet){
        fleetService.save(fleet);
        return ResponseEntity.ok().body("Fleet saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> allfleets(){
        return ResponseEntity.ok(fleetService.listall());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findFleet(@PathVariable("id")int id){
        return ResponseEntity.ok(fleetService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFleet(@PathVariable("id") int id){
        fleetService.deleteFleet(id);
        return ResponseEntity.ok().body("Fleet deleted successfully");
    }
}
