package org.example.LLDUseCase.parkinglot.Stragies;

import org.example.LLDUseCase.parkinglot.models.Ticket;

public interface FeeStrategy {

    double calculateFee(Ticket ticket);
}
