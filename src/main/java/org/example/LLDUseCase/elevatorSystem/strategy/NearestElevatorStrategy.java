package org.example.LLDUseCase.elevatorSystem.strategy;

import java.util.List;
import java.util.Optional;
import org.example.LLDUseCase.elevatorSystem.enums.Direction;
import org.example.LLDUseCase.elevatorSystem.model.Elevator;
import org.example.LLDUseCase.elevatorSystem.model.Request;

public class NearestElevatorStrategy implements  ElevatorSelectionStrategy {

    /**
     * This method selects the nearest suitable elevator based on the request.
     * It iterates through the list of elevators, checking if each elevator is suitable for the request.
     * If an elevator is suitable, it calculates the distance to the target floor and keeps track of the nearest one.
     *
     * @param elevators List of available elevators
     * @param request   The request containing target floor and direction
     * @return An Optional containing the selected Elevator if found, otherwise an empty Optional
     */
    @Override
    public Optional<Elevator> selectElevator(List<Elevator> elevators, Request request){

        int minDistance = Integer.MAX_VALUE;
        Elevator selectedElevator = null;

        for(Elevator elevator : elevators) {
            if(isSuitableElevator(elevator, request)) {
                int distance = Math.abs(elevator.getCurrentFloor() - request.getTargetFloor());
                if (distance < minDistance) {
                    minDistance = distance;
                    selectedElevator = elevator;
                }
            }
        }

        return Optional.ofNullable(selectedElevator);
    }


    /**
     * This method checks if an elevator is suitable for a given request.
     * An elevator is considered suitable if it is idle or if it is moving in the same direction as the request
     * and can reach the target floor without changing direction.
     *
     * @param elevator The elevator to check
     * @param request  The request containing target floor and direction
     * @return true if the elevator is suitable, false otherwise
     */
    public boolean isSuitableElevator(Elevator elevator, Request request) {

        if (elevator.getDirection() == Direction.IDLE) {
            return true;
        }

        if (elevator.getDirection() == request.getDirection()) {
            if (request.getDirection() == Direction.UP && elevator.getCurrentFloor() <= request.getTargetFloor()) {
                return true;
            }
            if (request.getDirection() == Direction.DOWN && elevator.getCurrentFloor() >= request.getTargetFloor()) {
                return true;
            }
        }
        return false;
    }

}
