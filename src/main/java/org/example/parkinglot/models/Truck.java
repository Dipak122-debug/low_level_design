package org.example.parkinglot.models;

import org.example.parkinglot.enums.VehicleType;

public class Truck extends Vehicle{

    public Truck(String licenseplate) {
        super(licenseplate, VehicleType.TRUCK);
    }
}
