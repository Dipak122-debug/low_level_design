package org.example.LLDUseCase.billingSystem.interfaces;

import org.example.LLDUseCase.billingSystem.enums.PaymentStatus;

public interface PaymentMethod {

    PaymentStatus pay(double amount);
}
