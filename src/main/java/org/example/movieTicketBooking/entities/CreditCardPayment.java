package org.example.movieTicketBooking.entities;

import org.example.movieTicketBooking.enums.PaymentStatus;
import org.example.movieTicketBooking.interfaces.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public PaymentStatus pay(double amount) {
        // Implement credit card payment logic here
        // For simplicity, we assume the payment is always successful
        return PaymentStatus.SUCCESS;
    }
}
