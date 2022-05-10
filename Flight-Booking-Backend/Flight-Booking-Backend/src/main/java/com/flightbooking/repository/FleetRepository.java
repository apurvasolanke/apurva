package com.flightbooking.repository;

import com.flightbooking.models.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FleetRepository extends JpaRepository<Fleet,Integer> {
}
