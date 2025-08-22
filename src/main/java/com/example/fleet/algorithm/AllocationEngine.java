package com.example.fleet.algorithm;

import com.example.fleet.model.Vehicle;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class AllocationEngine {

    public Map<Vehicle, List<String>> allocateVehicles(List<Vehicle> vehicles, List<String> requests) {
        Map<Vehicle, List<String>> allocationMap = new HashMap<>();

        for (String request : requests) {
            Vehicle bestVehicle = findBestVehicle(vehicles, request);
            if (bestVehicle != null) {
                allocationMap.computeIfAbsent(bestVehicle, k -> new ArrayList<>()).add(request);
                vehicles.remove(bestVehicle);
            }
        }
        return allocationMap;
    }

    // New helper used by AllocationService
    public Vehicle allocate(List<Vehicle> availableVehicles, int demand) {
        if (availableVehicles == null || availableVehicles.size() < Math.max(1, demand)) {
            throw new IllegalArgumentException("Not enough vehicles available for allocation");
        }
        // Simple allocation: mark first 'demand' vehicles as allocated and return the first allocated vehicle
        Vehicle v = availableVehicles.get(0);
        v.setStatus("allocated");
        return v;
    }

    private Vehicle findBestVehicle(List<Vehicle> vehicles, String request) {
        // Implement logic to find the best vehicle based on request criteria
        for (Vehicle vehicle : vehicles) {
            if (isVehicleAvailable(vehicle, request)) {
                return vehicle;
            }
        }
        return null;
    }

    private boolean isVehicleAvailable(Vehicle vehicle, String request) {
        return vehicle.getStatus() != null && vehicle.getStatus().equalsIgnoreCase("available");
    }
}