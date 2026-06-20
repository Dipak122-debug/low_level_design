package org.example.movieTicketBooking.services;

import org.example.movieTicketBooking.enums.PaymentStatus;
import org.example.movieTicketBooking.interfaces.PaymentStrategy;

public class PaymentService {

    public PaymentStatus processPayment(PaymentStrategy paymentStrategy, double amount) {
        return paymentStrategy.pay(amount);
    }
}
