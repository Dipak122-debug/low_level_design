package org.example.LLDUseCase.elevatorSystem.model;

import org.example.LLDUseCase.elevatorSystem.enums.Direction;
import org.example.LLDUseCase.elevatorSystem.enums.RequestSource;

public class Request {
    int targetFloor;
    Direction direction;
    RequestSource requestSource;

    public Request(int targetFloor, Direction direction, RequestSource requestSource) {
        this.targetFloor = targetFloor;
        this.direction = direction;
        this.requestSource = requestSource;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public RequestSource getRequestSource() {
        return requestSource;
    }
}
