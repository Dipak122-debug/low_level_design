package org.example.LLDUseCase.elevatorSystem.strategy;

import java.util.List;
import java.util.Optional;
import org.example.LLDUseCase.elevatorSystem.model.Elevator;
import org.example.LLDUseCase.elevatorSystem.model.Request;

public interface ElevatorSelectionStrategy {

    Optional<Elevator> selectElevator(List<Elevator> elevators, Request request);
}
