package org.example.LLDUseCase.movieTicketBooking.entities;

import java.util.List;
import org.example.LLDUseCase.movieTicketBooking.enums.BookingStatus;



public class Booking {

    private String id;
    private User user;
    private Show show;
    private List<Seat> selectedSeats;
    private BookingStatus bookingStatus;
    private double amount;

    public Booking(String id, User user, Show show, List<Seat> selectedSeats, BookingStatus pending, double amount) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.selectedSeats = selectedSeats;

        this.bookingStatus = BookingStatus.PENDING;
        this.amount = amount;// Default status
    }

    public void confirmBooking() {
        this.bookingStatus = BookingStatus.CONFIRMED;
    }


   // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<Seat> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
