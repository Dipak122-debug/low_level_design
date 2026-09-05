package org.example.LLDUseCase.billingSystem.models;

public class Coupon {

    private String code;
    private double discountPercentage;

    public double apply(double amount){
        return amount - (amount * (discountPercentage/100));
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
