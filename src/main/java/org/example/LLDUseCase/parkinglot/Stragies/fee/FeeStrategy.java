package org.example.LLDUseCase.parkinglot.Stragies.fee;

import org.example.LLDUseCase.parkinglot.models.Ticket;

public interface FeeStrategy {

    double calculateFee(Ticket ticket);
}
