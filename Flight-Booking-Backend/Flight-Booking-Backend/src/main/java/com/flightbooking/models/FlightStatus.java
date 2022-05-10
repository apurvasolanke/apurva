package com.flightbooking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlightStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int remainingEconomySeats;
    private int remainingBuinessSeats;
    private int remainingPremiumSeats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRemainingEconomySeats() {
        return remainingEconomySeats;
    }

    public void setRemainingEconomySeats(int remainingEconomySeats) {
        this.remainingEconomySeats = remainingEconomySeats;
    }

    public int getRemainingBuinessSeats() {
        return remainingBuinessSeats;
    }

    public void setRemainingBuinessSeats(int remainingBuinessSeats) {
        this.remainingBuinessSeats = remainingBuinessSeats;
    }

    public int getRemainingPremiumSeats() {
        return remainingPremiumSeats;
    }

    public void setRemainingPremiumSeats(int remainingPremiumSeats) {
        this.remainingPremiumSeats = remainingPremiumSeats;
    }
}
