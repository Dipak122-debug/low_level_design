package org.example.LLDUseCase.billingSystem.services;

import java.time.LocalDate;
import org.example.LLDUseCase.billingSystem.enums.PaymentStatus;
import org.example.LLDUseCase.billingSystem.models.Invoice;

public class InvoiceService {

    public Invoice generateInvoice(double amount, PaymentStatus paymentStatus) {
        // Logic to generate invoice based on subscription details
        Invoice invoice = new Invoice();
        invoice.setAmount(amount);
        invoice.setPaymentStatus(paymentStatus);
        invoice.setDate(LocalDate.now());
        return invoice;
    }
}
