package org.example.LLDUseCase.elevatorSystem.state;

import org.example.LLDUseCase.elevatorSystem.enums.Direction;
import org.example.LLDUseCase.elevatorSystem.model.Elevator;
import org.example.LLDUseCase.elevatorSystem.model.Request;

public interface ElevatorState {

    void move(Elevator elevator);
    void addRequest(Elevator elevator, Request request);
    Direction getDirection();
    ;
}
