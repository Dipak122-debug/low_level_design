package org.example.LLDUseCase.movieTicketBooking.interfaces;

import org.example.LLDUseCase.movieTicketBooking.enums.PaymentStatus;

public interface PaymentStrategy {
    PaymentStatus pay(double amount);
}
