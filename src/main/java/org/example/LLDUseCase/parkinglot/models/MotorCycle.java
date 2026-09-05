package org.example.LLDUseCase.parkinglot.models;

import org.example.LLDUseCase.parkinglot.enums.VehicleType;

public class MotorCycle extends Vehicle{

    public MotorCycle(String licenseplate) {
        super(licenseplate, VehicleType.MOTORCYCLE);
    }
}
