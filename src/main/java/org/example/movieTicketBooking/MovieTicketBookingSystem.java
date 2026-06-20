package org.example.movieTicketBooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.movieTicketBooking.entities.Booking;
import org.example.movieTicketBooking.entities.Movie;
import org.example.movieTicketBooking.entities.Screen;
import org.example.movieTicketBooking.entities.Seat;
import org.example.movieTicketBooking.entities.Show;
import org.example.movieTicketBooking.entities.Theatre;
import org.example.movieTicketBooking.entities.UpiPayment;
import org.example.movieTicketBooking.entities.User;
import org.example.movieTicketBooking.enums.SeatType;
import org.example.movieTicketBooking.services.BookingService;

public class MovieTicketBookingSystem {

    public static void main(String[] args) {

        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat("1", SeatType.SILVER));
        seats.add(new Seat("2", SeatType.GOLD));
        seats.add(new Seat("3", SeatType.PLATINUM));
        // Create a movie
        Movie movie = new Movie("Inception", "Sci-Fi", 148);

        // Create a theater
        Theatre theater = new Theatre("Th001", "Grand Cinema", new ArrayList<>());

        Screen screen = new Screen("Sc001", new ArrayList<>());
        theater.getScreens().add(screen);



        // Create a show
        Show show = new Show("100", movie, theater, "2024-06-15 19:00");

        // Create seats

        screen.getSeats().addAll(seats);



        // Create a user
        User user = new User("John Doe", "john.doe@example.com");

        BookingService bookingService =
                new BookingService();

        List<Seat> selectedSeats =
                Arrays.asList(
                        seats.get(0),
                        seats.get(1));

        Booking booking =
                bookingService.bookTickets(
                        user,
                        show,
                        selectedSeats,
                        new UpiPayment("UPI123456"));

        System.out.println(
                "Booking ID : "
                        + booking.getId());

        System.out.println(
                "Booking Status : "
                        + booking.getBookingStatus());
    }
}
