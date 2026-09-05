package org.example.LLDUseCase.movieTicketBooking.services;

import org.example.LLDUseCase.movieTicketBooking.enums.PaymentStatus;
import org.example.LLDUseCase.movieTicketBooking.interfaces.PaymentStrategy;

public class PaymentService {

    public PaymentStatus processPayment(PaymentStrategy paymentStrategy, double amount) {
        return paymentStrategy.pay(amount);
    }
}
