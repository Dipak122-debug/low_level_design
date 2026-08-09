package org.example.parkinglot.Stragies;

import org.example.parkinglot.models.Ticket;

public class FlatRatePaymentStrategy implements FeeStrategy{

    @Override
    public double calculateFee(Ticket ticket){

        final double RATE_PER_HOUR = 10;

        long duration = ticket.getExitTime()-ticket.getEntrytime();

        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * RATE_PER_HOUR;
    }
}
