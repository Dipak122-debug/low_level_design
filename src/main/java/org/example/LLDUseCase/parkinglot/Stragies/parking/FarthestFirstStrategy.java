package org.example.LLDUseCase.parkinglot.Stragies.parking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.example.LLDUseCase.parkinglot.models.ParkingFloor;
import org.example.LLDUseCase.parkinglot.models.ParkingSpot;
import org.example.LLDUseCase.parkinglot.models.Vehicle;

public class FarthestFirstStrategy implements ParkingStrategy {

    @Override
    public Optional<ParkingSpot> findAvailableSpot(List<ParkingFloor> parkingFloors, Vehicle vehicle) {

        Collections.reverse(parkingFloors);
        for(ParkingFloor  parkingFloor : parkingFloors){
            Optional<ParkingSpot> availableSpot = parkingFloor.findAvailableSpot(vehicle);
            if (availableSpot.isPresent()) {
                return availableSpot;
            }
        }
        return Optional.empty();
    }

}
