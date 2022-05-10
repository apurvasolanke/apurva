package com.flightbooking.dtos;

import com.flightbooking.models.Passenger;

public class PassengerDTO extends Passenger {
    private int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
