package org.example.LLDUseCase.billingSystem.models;

import org.example.LLDUseCase.billingSystem.enums.PlanType;

public class PlanFactory {

    public static Plan createPlan(PlanType planType){

        switch (planType){
            case BASIC:
                return new BasicPlan();
            case PRO:
                return new ProPlan();
            case ENTERPRISE:
                return new EnterprisePlan();
            default:
                throw new IllegalArgumentException("Invalid plan type: " + planType);
        }
    }
}
