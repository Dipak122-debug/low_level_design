package org.example.LLDUseCase.parkinglot.models;

import org.example.LLDUseCase.parkinglot.enums.VehicleType;

public abstract class Vehicle {

    private String licenseplate;
    private VehicleType vehicleType;

    public Vehicle(String licenseplate, VehicleType vehicleType) {
        this.licenseplate = licenseplate;
        this.vehicleType = vehicleType;
    }

    public String getLicenseplate(){
        return licenseplate;
    }

    public VehicleType getVehicleType(){
        return vehicleType;

    }

}