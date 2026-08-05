package org.example.billingSystem.models;

import org.example.billingSystem.enums.BillingCycle;

public class ProPlan extends Plan{

    public ProPlan() {
        name = "ProPlan";
        monthlyPrice=199;
        annualPrice=1999;
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
