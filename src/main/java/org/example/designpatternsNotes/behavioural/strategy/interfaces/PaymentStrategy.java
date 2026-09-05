package org.example.designpatternsNotes.behavioural.strategy.interfaces;

public interface PaymentStrategy {
    void collectPaymentDetails();
    boolean validatePayment();
    void pay(int amount);
}
