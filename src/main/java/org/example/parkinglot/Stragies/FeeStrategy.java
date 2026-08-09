package org.example.parkinglot.Stragies;

import org.example.parkinglot.models.Ticket;

public interface FeeStrategy {

    double calculateFee(Ticket ticket);
}
