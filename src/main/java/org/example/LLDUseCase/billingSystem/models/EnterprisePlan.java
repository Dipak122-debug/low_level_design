package org.example.LLDUseCase.billingSystem.models;

import org.example.LLDUseCase.billingSystem.enums.BillingCycle;

public class EnterprisePlan extends Plan{

    public EnterprisePlan() {
        name = "Enterprise Plan";
        monthlyPrice=499;
        annualPrice=4999;
    }

    @Override
    public double getPrice(BillingCycle billingCycle) {
        if(billingCycle.equals(BillingCycle.MONTHLY)){
            return monthlyPrice;
        }else {
            return annualPrice;
        }
    }
}
