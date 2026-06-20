package org.example.parkinglot.models;

import org.example.parkinglot.enums.VehicleType;

public class MotorCycle extends Vehicle{

    public MotorCycle(String licenseplate) {
        super(licenseplate, VehicleType.MOTORCYCLE);
    }
}
