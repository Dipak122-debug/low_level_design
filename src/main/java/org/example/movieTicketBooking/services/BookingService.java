package org.example.movieTicketBooking.services;

import java.util.List;
import java.util.UUID;
import org.example.movieTicketBooking.entities.Booking;
import org.example.movieTicketBooking.entities.Seat;
import org.example.movieTicketBooking.entities.Show;
import org.example.movieTicketBooking.entities.User;
import org.example.movieTicketBooking.enums.BookingStatus;
import org.example.movieTicketBooking.enums.PaymentStatus;
import org.example.movieTicketBooking.interfaces.PaymentStrategy;

public class BookingService {
    private PaymentService paymentService =
            new PaymentService();

    public Booking bookTickets(User user,
                               Show show,
                               List<Seat> selectedSeats,
                               PaymentStrategy paymentStrategy) {

        for(Seat seat : selectedSeats) {
            if(seat.isBooked()) {
                throw new RuntimeException("Selected seat " + seat.getSeatId() + " is not available.");
            }
            seat.bookSeat();
        }

        double totalAmount = selectedSeats.size() * 200;

        Booking booking = new Booking(
                UUID.randomUUID().toString(), // Generate a unique booking ID
                user,
                show,
                selectedSeats,
                BookingStatus.PENDING,
                totalAmount
        );

         PaymentStatus paymentStatus = paymentService.processPayment(paymentStrategy, totalAmount);

         if(paymentStatus == PaymentStatus.SUCCESS) {
             booking.confirmBooking();
             return booking;
         } else {
             // If payment fails, release the booked seats
             for(Seat seat : selectedSeats) {
                 seat.releaseSeat();
             }
             throw new RuntimeException("Payment failed. Booking could not be completed.");
         }

    }
}
