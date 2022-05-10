package com.flightbooking.dtos;

import com.flightbooking.models.Booking;

public class BookingDTO extends Booking {
    private int flightid;
    private int userid;
    private int passengerid;

    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(int passengerid) {
        this.passengerid = passengerid;
    }
}
