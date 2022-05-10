package com.flightbooking.services;

import com.flightbooking.models.Location;
import com.flightbooking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired private LocationRepository repo;

    public void saveLocation(Location location){
        repo.save(location);
    }

    public void deleteLocation(int id){
        repo.delete(repo.getById(id));
    }

    public List<Location> listall(){
        return repo.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    public Location findById(int id){
        return repo.getById(id);
    }

    public List<Location> listCities(String state){
        return repo.findDistinctByState(state);
    }

    public List<Location> listStates(String country){
        return repo.findDistinctByCountry(country);
    }
}
