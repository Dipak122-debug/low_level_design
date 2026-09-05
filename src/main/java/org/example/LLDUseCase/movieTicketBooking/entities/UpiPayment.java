package org.example.LLDUseCase.movieTicketBooking.entities;

import org.example.LLDUseCase.movieTicketBooking.enums.PaymentStatus;
import org.example.LLDUseCase.movieTicketBooking.interfaces.PaymentStrategy;

public class UpiPayment implements PaymentStrategy {

    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public PaymentStatus pay(double amount) {
        // Simulate UPI payment processing
        System.out.println("Processing UPI payment of " + amount + " for UPI ID: " + upiId);
        // For simplicity, we assume the payment is always successful
        return PaymentStatus.SUCCESS;
    }
}
