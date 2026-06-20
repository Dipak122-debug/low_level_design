package org.example.parkinglot.models;

import org.example.parkinglot.enums.VehicleType;

public class Car extends Vehicle{

    public Car(String licenseplate) {
        super(licenseplate, VehicleType.CAR);
    }
}
