package org.example.LLDUseCase.elevatorSystem.state;

import org.example.LLDUseCase.elevatorSystem.enums.Direction;
import org.example.LLDUseCase.elevatorSystem.enums.RequestSource;
import org.example.LLDUseCase.elevatorSystem.model.Elevator;
import org.example.LLDUseCase.elevatorSystem.model.Request;

public class MovingDownState implements ElevatorState {

    @Override
    public void move(Elevator elevator) {

        if (elevator.getDownRequests().isEmpty()) {
            elevator.setState(new IdleState());
            return;
        }

        int nextFloor = elevator.getDownRequests().first();
        elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);

        if (elevator.getCurrentFloor() == nextFloor) {

            System.out.println("Elevator has arrived at floor: " + elevator.getCurrentFloor());
            elevator.getDownRequests().pollFirst();
        }

        if (elevator.getDownRequests().isEmpty()) {
            elevator.setState(new IdleState());
        }

    }

    @Override
    public void addRequest(Elevator elevator, Request request) {

        //External
        if (request.getDirection() == Direction.DOWN && request.getTargetFloor() <= elevator.getCurrentFloor()) {
            elevator.getDownRequests().add(request.getTargetFloor());
        } else if (request.getDirection() == Direction.UP) {
            elevator.getUpRequests().add(request.getTargetFloor());
        }

        //Internal
        if (request.getRequestSource() == RequestSource.INTERNAL) {
            if (request.getTargetFloor() < elevator.getCurrentFloor()) {
                elevator.getDownRequests().add(request.getTargetFloor());
            } else {
                elevator.getUpRequests().add(request.getTargetFloor());
            }
        }
    }

    @Override
    public Direction getDirection() {
        System.out.println("Elevator is moving down.");
        return Direction.DOWN;
    }

}