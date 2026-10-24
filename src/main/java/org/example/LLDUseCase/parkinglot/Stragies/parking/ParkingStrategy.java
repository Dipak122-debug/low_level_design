package org.example.LLDUseCase.parkinglot.Stragies.parking;

import java.util.List;
import java.util.Optional;
import org.example.LLDUseCase.parkinglot.models.ParkingFloor;
import org.example.LLDUseCase.parkinglot.models.ParkingSpot;
import org.example.LLDUseCase.parkinglot.models.Vehicle;

public interface ParkingStrategy {

    Optional<ParkingSpot> findAvailableSpot(List<ParkingFloor> parkingFloors, Vehicle vehicle);
}
