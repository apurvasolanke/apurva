package com.flightbooking.services;

import com.flightbooking.dtos.LoginDTO;
import com.flightbooking.models.Contact;
import com.flightbooking.models.User;
import com.flightbooking.repository.ContactRepository;
import com.flightbooking.repository.LocationRepository;
import com.flightbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepository repo;
    @Autowired private ContactRepository crepo;

    public User saveUser(User user){
        Contact contact=crepo.saveAndFlush(user.getContact());
        user.setContact(contact);
        return repo.save(user);
    }

    public List<User> allusers(){
        return repo.findAll(Sort.by(Sort.Direction.DESC,"createdOn"));
    }

    public User findByName(String userName){
        return repo.findByUserName(userName);
    }

    public User findByEmail(String email){
        return repo.findByEmail(email);
    }

    public User findByUserId(int id){
        return repo.getById(id);
    }

    public User validate(LoginDTO dto){
        User user=repo.findByUserName(dto.getUserName());
        if(user!=null && user.getPassword().equals(dto.getPassword())){
            return user;
        }
        return null;
    }
}
