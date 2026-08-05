package org.example.billingSystem.services;

import org.example.billingSystem.interfaces.PaymentMethod;
import org.example.billingSystem.models.Payment;

public class PaymentService {

    public Payment processPayment(PaymentMethod paymentMethod, double amount) {

        Payment payment = new Payment();
        payment.setPaymentStatus(paymentMethod.pay(amount));

        return payment;
    }

}
