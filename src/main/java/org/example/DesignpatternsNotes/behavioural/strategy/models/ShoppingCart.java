package org.example.DesignpatternsNotes.behavioural.strategy.models;

import org.example.DesignpatternsNotes.behavioural.strategy.interfaces.PaymentStrategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Injecting the strategy at runtime
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int totalAmount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not defined.");
        }
        paymentStrategy.collectPaymentDetails();
        if (paymentStrategy.validatePayment()) {
            paymentStrategy.pay(totalAmount);
        }
    }
}