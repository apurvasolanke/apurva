package com.flightbooking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fleet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String model;
    private int totalEconomySeats;
    private int totalBuinessSeats;
    private int totalPremiumSeats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTotalEconomySeats() {
        return totalEconomySeats;
    }

    public void setTotalEconomySeats(int totalEconomySeats) {
        this.totalEconomySeats = totalEconomySeats;
    }

    public int getTotalBuinessSeats() {
        return totalBuinessSeats;
    }

    public void setTotalBuinessSeats(int totalBuinessSeats) {
        this.totalBuinessSeats = totalBuinessSeats;
    }

    public int getTotalPremiumSeats() {
        return totalPremiumSeats;
    }

    public void setTotalPremiumSeats(int totalPremiumSeats) {
        this.totalPremiumSeats = totalPremiumSeats;
    }

    @Override
    public String toString() {
        return "Fleet{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", model='" + model + '\'' +
                ", totalEconomySeats=" + totalEconomySeats +
                ", totalBuinessSeats=" + totalBuinessSeats +
                ", totalPremiumSeats=" + totalPremiumSeats +
                '}';
    }
}
