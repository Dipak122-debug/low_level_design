package org.example.billingSystem;

import org.example.billingSystem.enums.BillingCycle;
import org.example.billingSystem.enums.PlanType;
import org.example.billingSystem.models.CardPayment;
import org.example.billingSystem.models.Coupon;
import org.example.billingSystem.models.Invoice;
import org.example.billingSystem.models.UpiPayment;
import org.example.billingSystem.models.User;
import org.example.billingSystem.services.BillingService;

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
