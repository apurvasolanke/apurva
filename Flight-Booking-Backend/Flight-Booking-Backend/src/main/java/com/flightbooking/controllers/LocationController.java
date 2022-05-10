package com.flightbooking.controllers;

import com.flightbooking.models.Location;
import com.flightbooking.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<?> saveLocation(@RequestBody Location location){
        locationService.saveLocation(location);
        return ResponseEntity.ok().body("Location saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listallLocations(){
        return ResponseEntity.ok(locationService.listall());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findLocations(@PathVariable("id")int id){
        return ResponseEntity.ok(locationService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable("id") int id){
        locationService.deleteLocation(id);
        return ResponseEntity.ok().body("Location deleted successfully");
    }
}
