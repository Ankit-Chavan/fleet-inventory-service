package com.example.fleet.dto;

// ...existing code...
public class AllocationRequestDto {
    private String vehicleType;
    private int demand;

    public AllocationRequestDto() {}

    public AllocationRequestDto(String vehicleType, int demand) {
        this.vehicleType = vehicleType;
        this.demand = demand;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }
}