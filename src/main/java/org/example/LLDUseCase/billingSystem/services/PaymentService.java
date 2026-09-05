package org.example.LLDUseCase.billingSystem.services;

import org.example.LLDUseCase.billingSystem.interfaces.PaymentMethod;
import org.example.LLDUseCase.billingSystem.models.Payment;

public class PaymentService {

    public Payment processPayment(PaymentMethod paymentMethod, double amount) {

        Payment payment = new Payment();
        payment.setPaymentStatus(paymentMethod.pay(amount));

        return payment;
    }

}
