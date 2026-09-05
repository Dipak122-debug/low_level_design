package org.example.LLDUseCase.billingSystem.models;

import org.example.LLDUseCase.billingSystem.enums.PaymentStatus;
import org.example.LLDUseCase.billingSystem.interfaces.PaymentMethod;

public class PayPalPayment implements PaymentMethod {

    @Override
    public PaymentStatus pay(double amount) {
        System.out.println("Processing PayPal payment of amount: " + amount);
        return PaymentStatus.SUCCESS;
    }
}
