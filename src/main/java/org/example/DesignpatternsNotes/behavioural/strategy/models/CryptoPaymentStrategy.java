package org.example.DesignpatternsNotes.behavioural.strategy.models;

import org.example.DesignpatternsNotes.behavioural.strategy.interfaces.PaymentStrategy;

public class CryptoPaymentStrategy implements PaymentStrategy {

    @Override
    public void collectPaymentDetails() { /* ... */ }

    @Override
    public boolean validatePayment() { return true; }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cryptocurrency.");
    }
}
