package org.example.movieTicketBooking.interfaces;

import org.example.movieTicketBooking.enums.PaymentStatus;

public interface PaymentStrategy {
    PaymentStatus pay(double amount);
}
