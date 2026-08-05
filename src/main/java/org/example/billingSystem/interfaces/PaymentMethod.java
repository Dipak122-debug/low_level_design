package org.example.billingSystem.interfaces;

import org.example.billingSystem.enums.PaymentStatus;

public interface PaymentMethod {

    PaymentStatus pay(double amount);
}
