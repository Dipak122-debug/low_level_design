package org.example.LLDUseCase.billingSystem.models;

import java.time.LocalDate;
import org.example.LLDUseCase.billingSystem.enums.PaymentStatus;

public class Invoice {
    private String invoiceId;
    private double amount;
    private LocalDate date;
    private PaymentStatus paymentStatus;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
