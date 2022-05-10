package com.flightbooking.controllers;

import com.flightbooking.dtos.LoginDTO;
import com.flightbooking.models.User;
import com.flightbooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService uservice;

    @PostMapping("/validate")
    public ResponseEntity<?> validate(@RequestBody LoginDTO dto){
        User user=uservice.validate(dto);
        if(user!=null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user){
        if(uservice.findByName(user.getUserName())!=null){
            return ResponseEntity.badRequest().body("Username not available");
        }
        if(uservice.findByEmail(user.getEmail())!=null){
            return ResponseEntity.badRequest().body("Email already exists");
        }
        uservice.saveUser(user);
        return ResponseEntity.ok().body("User registered successfully");
    }

    @GetMapping
    public ResponseEntity<?> listall(){
        return ResponseEntity.ok(uservice.allusers());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findDetails(@PathVariable("id") int id){
        return ResponseEntity.ok().body(uservice.findByUserId(id));
    }
}
