package com.flightbooking.services;

import com.flightbooking.models.Fleet;
import com.flightbooking.repository.FleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FleetService {
    @Autowired private FleetRepository repo;

    public void save(Fleet fleet){
        repo.save(fleet);
    }

    public List<Fleet> listall(){
        return repo.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    public Fleet findById(int id){
        return repo.getById(id);
    }

    public void deleteFleet(int id){
        repo.delete(repo.getById(id));
    }
}
