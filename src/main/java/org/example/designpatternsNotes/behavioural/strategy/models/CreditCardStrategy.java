package org.example.designpatternsNotes.behavioural.strategy.models;

import org.example.designpatternsNotes.behavioural.strategy.interfaces.PaymentStrategy;

public class CreditCardStrategy implements PaymentStrategy {

    @Override
    public void collectPaymentDetails() { /* ... */ }

    @Override
    public boolean validatePayment() { return true; }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cryptocurrency.");
    }
}
