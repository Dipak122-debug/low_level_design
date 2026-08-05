package org.example.billingSystem.models;

import org.example.billingSystem.enums.BillingCycle;

public class BasicPlan extends Plan{

    public BasicPlan() {
        name = "BasicPlan";
        monthlyPrice=99;
        annualPrice=999;
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
