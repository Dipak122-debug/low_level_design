package org.example.billingSystem.models;

import org.example.billingSystem.enums.PaymentStatus;
import org.example.billingSystem.interfaces.PaymentMethod;

public class UpiPayment implements PaymentMethod {

    @Override
    public PaymentStatus pay(double amount) {
        System.out.println("Processing UPI payment of amount: " + amount);
        return PaymentStatus.SUCCESS;
    }

}
