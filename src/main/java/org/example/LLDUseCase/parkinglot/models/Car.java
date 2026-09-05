package org.example.LLDUseCase.parkinglot.models;

import org.example.LLDUseCase.parkinglot.enums.VehicleType;

public class Car extends Vehicle{

    public Car(String licenseplate) {
        super(licenseplate, VehicleType.CAR);
    }
}
