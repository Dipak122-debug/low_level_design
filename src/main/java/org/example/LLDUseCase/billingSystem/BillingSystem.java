package org.example.LLDUseCase.billingSystem;

import org.example.LLDUseCase.billingSystem.enums.BillingCycle;
import org.example.LLDUseCase.billingSystem.enums.PlanType;
import org.example.LLDUseCase.billingSystem.models.Coupon;
import org.example.LLDUseCase.billingSystem.models.Invoice;
import org.example.LLDUseCase.billingSystem.models.UpiPayment;
import org.example.LLDUseCase.billingSystem.models.User;
import org.example.LLDUseCase.billingSystem.services.BillingService;

public class BillingSystem {

    public static void main(String[] args) {
        User user = new User();
        user.setName("Dipak");
        BillingService billingService = new BillingService();
        Coupon coupon = new Coupon();
        coupon.setCode("DISCOUNT10");
        coupon.setDiscountPercentage(10.0);
        BillingService service = new BillingService();

        Invoice invoice = service.subscribe(
                user,
                PlanType.PRO,
                BillingCycle.MONTHLY,
                coupon,
                new UpiPayment());

        System.out.println(invoice.toString());
    }


}
