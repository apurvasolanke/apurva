package com.flightbooking.dtos;

import java.time.LocalDate;

public class SearchDTO {
    private int fromlocation;
    private int tolocation;
    private LocalDate flightDate;

    public int getFromlocation() {
        return fromlocation;
    }

    public void setFromlocation(int fromlocation) {
        this.fromlocation = fromlocation;
    }

    public int getTolocation() {
        return tolocation;
    }

    public void setTolocation(int tolocation) {
        this.tolocation = tolocation;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "fromlocation=" + fromlocation +
                ", tolocation=" + tolocation +
                ", flightDate=" + flightDate +
                '}';
    }
}
