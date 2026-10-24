package org.example.LLDUseCase.elevatorSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import org.example.LLDUseCase.elevatorSystem.enums.Direction;
import org.example.LLDUseCase.elevatorSystem.enums.RequestSource;
import org.example.LLDUseCase.elevatorSystem.model.Elevator;
import org.example.LLDUseCase.elevatorSystem.model.Request;
import org.example.LLDUseCase.elevatorSystem.strategy.ElevatorSelectionStrategy;
import org.example.LLDUseCase.elevatorSystem.strategy.NearestElevatorStrategy;

public class ElevatorSystem {

    private static ElevatorSystem instance;
    private final Map<Integer, Elevator> elevators;
    private final ElevatorSelectionStrategy elevatorSelectionStrategy;
    private final ExecutorService executorService;

    public ElevatorSystem(int numOfElevators) {
        List<Elevator> elevatorList = new ArrayList<>();
        this.elevatorSelectionStrategy = new NearestElevatorStrategy();
        this.executorService = Executors.newFixedThreadPool(numOfElevators);

        for(int i = 1; i <= numOfElevators; i++) {
            Elevator elevator = new Elevator(i);
            elevatorList.add(elevator);
        }

        this.elevators = elevatorList.stream().collect(Collectors.toMap(Elevator::getId, e -> e));
    }

    public static synchronized ElevatorSystem getInstance(int numOfElevators) {
        if (instance == null) {
            instance = new ElevatorSystem(numOfElevators);
        }
        return instance;
    }

    public void start() {
        for (Elevator elevator : elevators.values()) {
            executorService.submit(elevator);
        }
    }

    //External request from a floor
    public void requestElevator(int floor, Direction direction) {

        Request request = new Request(floor, direction, RequestSource.EXTERNAL);
        Optional<Elevator> selectedElevator = elevatorSelectionStrategy.selectElevator(new ArrayList<>(elevators.values()), request);
        if (selectedElevator.isPresent()) {
            selectedElevator.get().addRequest(request);
        } else {
            System.out.println("No available elevators to handle the request at floor " + floor + " going " + direction);
        }
    }

    //Internal request from inside an elevator
    public void requestFloor(int elevatorId, int targetFloor) {
        Elevator elevator = elevators.get(elevatorId);
        if (elevator != null) {
            Request request = new Request(targetFloor, Direction.IDLE, RequestSource.INTERNAL);
            elevator.addRequest(request);
        }
        else {
            System.out.println("Elevator with ID " + elevatorId + " does not exist.");
        }
    }

    public void shutdown() {
        System.out.println("Shutting down elevator system...");
        for (Elevator elevator : elevators.values()) {
            elevator.stopElevator();
        }
        executorService.shutdown();
    }
}
