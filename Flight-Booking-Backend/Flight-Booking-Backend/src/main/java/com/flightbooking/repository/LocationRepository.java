package com.flightbooking.repository;

import com.flightbooking.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository  extends JpaRepository<Location,Integer> {
    List<Location> findDistinctByState(String state);
    List<Location> findDistinctByCountry(String country);
}
