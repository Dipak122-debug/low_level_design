package org.example.LLDUseCase.parkinglot.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.example.LLDUseCase.parkinglot.enums.SpotType;

public class ParkingFloor {
    private final String id;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(String id, List<ParkingSpot> parkingSpots) {
        this.id = id;
        this.parkingSpots = new ArrayList<>();
    }

    public  void addSpot(ParkingSpot spot){
        parkingSpots.add(spot);
    }

    public Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle){

        return parkingSpots.stream()
                .filter(spot -> !spot.isOccupied() && spot.canFitVehicle(vehicle))
                .toList().stream().findFirst();

    }

    public void displaySpotAvailability(){

        Map<SpotType,Long> availabilityMap = parkingSpots.stream()
                .filter(spot -> !spot.isOccupied())
                .collect(Collectors.groupingBy(ParkingSpot :: getSpotType, Collectors.counting()));

        for(SpotType spotType : SpotType.values()){
            System.out.println(spotType +" spot is available of count "+availabilityMap.getOrDefault(spotType,0L));
        }

    }







}
