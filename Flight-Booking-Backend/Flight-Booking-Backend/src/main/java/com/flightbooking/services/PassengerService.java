package com.flightbooking.services;

import com.flightbooking.dtos.PassengerDTO;
import com.flightbooking.models.Passenger;
import com.flightbooking.models.User;
import com.flightbooking.repository.PassengerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired private PassengerRepository repo;
    @Autowired private UserService userService;

    public void savePassenger(PassengerDTO dto){
        Passenger passenger=new Passenger();
        BeanUtils.copyProperties(dto,passenger);
        passenger.setCreatedBy(userService.findByUserId(dto.getUserid()));
        repo.save(passenger);
    }

    public List<Passenger> listall(){
        return repo.findAll();
    }

    public List<Passenger> userPassengers(int userid){
        return repo.findByCreatedBy(userService.findByUserId(userid));
    }

    public Passenger findById(int id){
        return repo.getById(id);
    }

    public void deletePassenger(int id){
        repo.delete(repo.getById(id));
    }
}
