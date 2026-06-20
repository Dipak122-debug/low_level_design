package org.example.movieTicketBooking.entities;

import java.util.List;


public class Screen {
    private String id;
    List<Seat> seats;

    //constructor
    public Screen(String id, List<Seat> seats) {
        this.id = id;
        this.seats = seats;
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
