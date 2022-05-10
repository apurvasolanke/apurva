package com.flightbooking.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Flight {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name="departure_location_id")
    private Location departureLocation;
    @ManyToOne
    @JoinColumn(name="arrival_location_id")
    private Location arrivalLocation;
    @ManyToOne
    @JoinColumn(name = "fleet_id")
    private Fleet fleet;
    private LocalDate flightDate;

    private LocalTime departureTime;
    private LocalTime arrivalTime;
    @OneToOne
    @JoinColumn(name="flight_status_id")
    private FlightStatus flightStatus;
    @OneToOne
    @JoinColumn(name="fare_id")
    private Fare fare;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(Location departureLocation) {
        this.departureLocation = departureLocation;
    }

    public Location getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(Location arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departureLocation=" + departureLocation +
                ", arrivalLocation=" + arrivalLocation +
                ", fleet=" + fleet +
                ", flightDate=" + flightDate +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", flightStatus=" + flightStatus +
                ", fare=" + fare +
                '}';
    }
}
