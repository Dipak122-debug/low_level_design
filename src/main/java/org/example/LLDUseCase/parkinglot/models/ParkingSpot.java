package org.example.LLDUseCase.parkinglot.models;

import org.example.LLDUseCase.parkinglot.enums.SpotType;

public class ParkingSpot {
    private String id;
    private Vehicle parkedVehicle;
    private SpotType spotType;
    private boolean isOccupied;

    public ParkingSpot(String spotId, SpotType spotType) {
        this.id = spotId;
        this.spotType = spotType;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void parkVehicle(Vehicle vehicle){
        this.parkedVehicle=vehicle;
        isOccupied=true;
    }

    public void unparkVehicle(Vehicle vehicle){
        this.parkedVehicle=null;
        setOccupied(false);
    }

    public boolean canFitVehicle(Vehicle vehicle){

        if(isOccupied) return false;

        return switch (vehicle.getVehicleType()){
            case MOTORCYCLE -> spotType==SpotType.SMALL;
            case CAR -> spotType==SpotType.MEDIUM;
            case TRUCK -> spotType==SpotType.LARGE;
        };
    }
}
