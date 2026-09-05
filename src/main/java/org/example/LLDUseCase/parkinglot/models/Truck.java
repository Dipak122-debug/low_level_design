package org.example.LLDUseCase.parkinglot.models;

import org.example.LLDUseCase.parkinglot.enums.VehicleType;

public class Truck extends Vehicle{

    public Truck(String licenseplate) {
        super(licenseplate, VehicleType.TRUCK);
    }
}
