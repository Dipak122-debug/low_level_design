package org.example.LLDUseCase.elevatorSystem.model;

import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import org.example.LLDUseCase.elevatorSystem.enums.Direction;
import org.example.LLDUseCase.elevatorSystem.state.ElevatorState;
import org.example.LLDUseCase.elevatorSystem.state.IdleState;

public class Elevator implements Runnable {

    private final int id;
    private AtomicInteger currentFloor;
    private volatile boolean isRunning = true;

    private final TreeSet<Integer> upRequests;
    private final TreeSet<Integer> downRequests;

    private ElevatorState state;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = new AtomicInteger(0);
        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>((a, b) -> b - a);
        this.state = new IdleState();
    }

    void move() {
        state.move(this);
    }

    public synchronized void addRequest(Request request) {

        System.out.println("Elevator " + id + " processing request " + request);
        state.addRequest(this, request);

    }

    @Override
    public void run() {

        while (isRunning) {
            move();
            try {
                Thread.sleep(1000); // Simulate time taken to move between floors
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                isRunning = false;
                System.out.println("Elevator " + id + " interrupted.");
            }
        }
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor.get();
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor.set(floor);
    }

    public boolean isRunning() {
        return isRunning;
    }


    public TreeSet<Integer> getUpRequests() {
        return upRequests;
    }

    public TreeSet<Integer> getDownRequests() {
        return downRequests;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;

    }

    public Direction getDirection() {
        return state.getDirection();
    }


    public void stopElevator() {
        isRunning = false;
    }

}
