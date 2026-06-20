package org.example.movieTicketBooking.entities;


import org.example.movieTicketBooking.enums.SeatType;


public class Seat {
    private String seatId;
    private SeatType seatType;
    private boolean booked;

    public Seat(String seatId, SeatType seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.booked = false;
    }
    public synchronized boolean bookSeat() {
        if (booked) {
            return false;
        }

        booked = true;
        return true;

    }

    public synchronized boolean releaseSeat() {
        if (!booked) {
            return false;
        }

        booked = false;
        return true;
    }

    public String getSeatId() {
        return seatId;
    }
    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }
    public SeatType getSeatType() {
        return seatType;
    }
    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
    public boolean isBooked() {
        return booked;
    }
    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
