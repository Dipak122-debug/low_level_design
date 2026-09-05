package org.example.LLDUseCase.billingSystem.models;

import org.example.LLDUseCase.billingSystem.enums.BillingCycle;

public abstract class Plan {

    protected String name;
    protected double monthlyPrice;
    protected double annualPrice;

    public abstract double getPrice(BillingCycle billingCycle);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public double getAnnualPrice() {
        return annualPrice;
    }

    public void setAnnualPrice(double annualPrice) {
        this.annualPrice = annualPrice;
    }
}
