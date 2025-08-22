package com.example.fleet.repository;

import com.example.fleet.model.InventoryItem;
import com.example.fleet.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    // Application code expects these — real implementations can be added (JPQL/@Query) later
    List<Vehicle> findAvailableVehicles(String vehicleType);
    List<Vehicle> findAllocatedVehicles();
}