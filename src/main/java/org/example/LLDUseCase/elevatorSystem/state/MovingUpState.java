package org.example.LLDUseCase.elevatorSystem.state;

import org.example.LLDUseCase.elevatorSystem.enums.Direction;
import org.example.LLDUseCase.elevatorSystem.enums.RequestSource;
import org.example.LLDUseCase.elevatorSystem.model.Elevator;
import org.example.LLDUseCase.elevatorSystem.model.Request;

public class MovingUpState implements ElevatorState {

    @Override
    public void move(Elevator elevator) {

        if(elevator.getUpRequests().isEmpty()){
            elevator.setState(new IdleState());
        }

        int nextFloor = elevator.getUpRequests().first();
        elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);

        if (elevator.getCurrentFloor() == nextFloor) {

            System.out.println("Elevator reached floor: " + nextFloor);
            elevator.getUpRequests().pollFirst();
        }

        if (elevator.getUpRequests().isEmpty()) {
            elevator.setState(new IdleState());
        }

    }

    @Override
    public void addRequest(Elevator elevator, Request request) {

        //Internal
        if(request.getRequestSource()== RequestSource.INTERNAL){
            if(request.getTargetFloor() > elevator.getCurrentFloor()){
                elevator.getUpRequests().add(request.getTargetFloor());
            }
            else if(request.getTargetFloor() < elevator.getCurrentFloor()){
                elevator.getDownRequests().add(request.getTargetFloor());
            }
        }

        //External
        else if(request.getRequestSource()== RequestSource.EXTERNAL){
            if(request.getDirection()== Direction.UP && request.getTargetFloor() > elevator.getCurrentFloor()){
                elevator.getUpRequests().add(request.getTargetFloor());
            }
            else if(request.getDirection()== Direction.DOWN){
                elevator.getDownRequests().add(request.getTargetFloor());
            }
        }
    }

    @Override
    public Direction getDirection() {
        return Direction.UP;
    }
}
