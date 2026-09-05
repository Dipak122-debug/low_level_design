package org.example.LLDUseCase.billingSystem.services;

import org.example.LLDUseCase.billingSystem.enums.BillingCycle;
import org.example.LLDUseCase.billingSystem.enums.PlanType;
import org.example.LLDUseCase.billingSystem.enums.SubscriptionStatus;
import org.example.LLDUseCase.billingSystem.interfaces.PaymentMethod;
import org.example.LLDUseCase.billingSystem.models.Coupon;
import org.example.LLDUseCase.billingSystem.models.Invoice;
import org.example.LLDUseCase.billingSystem.models.Payment;
import org.example.LLDUseCase.billingSystem.models.Plan;
import org.example.LLDUseCase.billingSystem.models.PlanFactory;
import org.example.LLDUseCase.billingSystem.models.Subscription;
import org.example.LLDUseCase.billingSystem.models.User;

public class BillingService {

    private PaymentService paymentService = new PaymentService();
    private InvoiceService invoiceService = new InvoiceService();

    public Invoice subscribe(User user, PlanType planType,
                             BillingCycle billingCycle,
                             Coupon coupon,
                             PaymentMethod paymentMethod) {

        Plan plan = PlanFactory.createPlan(planType);
        double amount = plan.getPrice(billingCycle);

        if(null!=coupon) amount = coupon.apply(amount);

        Payment payment = paymentService.processPayment(paymentMethod, amount);

        Subscription subscription = new Subscription();
       // subscription.setUser(user);
        subscription.setPlan(plan);
        subscription.setBillingCycle(billingCycle);
        subscription.setStatus(SubscriptionStatus.ACTIVE);

        user.setSubscription(subscription);


        return invoiceService.generateInvoice(amount,payment.getPaymentStatus());
    }
}
