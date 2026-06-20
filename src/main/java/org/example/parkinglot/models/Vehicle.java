package org.example.parkinglot.models;

import org.example.parkinglot.enums.VehicleType;

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