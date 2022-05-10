package com.flightbooking.dtos;

import com.flightbooking.models.Flight;

public class FlightDTO extends Flight {
    private int departureLocationId;
    private int arrivalLocationId;
    private int fleetId;

    public int getFleetId() {
        return fleetId;
    }

    public void setFleetId(int fleetId) {
        this.fleetId = fleetId;
    }

    public int getDepartureLocationId() {
        return departureLocationId;
    }

    public void setDepartureLocationId(int departureLocationId) {
        this.departureLocationId = departureLocationId;
    }

    public int getArrivalLocationId() {
        return arrivalLocationId;
    }

    public void setArrivalLocationId(int arrivalLocationId) {
        this.arrivalLocationId = arrivalLocationId;
    }

    @Override
    public String toString() {
        return "FlightDTO{" +
                "departureLocationId=" + departureLocationId +
                ", arrivalLocationId=" + arrivalLocationId +
                ", fleetId=" + fleetId +
                '}';
    }
}
