package com.example.fleet.service;

import com.example.fleet.dto.AllocationRequestDto;
import com.example.fleet.model.Vehicle;
import com.example.fleet.repository.InventoryRepository;
import com.example.fleet.algorithm.AllocationEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// ...existing code...
@Service
public class AllocationService {

    private final InventoryRepository inventoryRepository;
    private final AllocationEngine allocationEngine;

    // simple in-memory store: allocationId -> list of vehicleIds
    private final Map<Long, List<Long>> allocations = new ConcurrentHashMap<>();
    private final AtomicLong allocationIdCounter = new AtomicLong(1);

    @Autowired
    public AllocationService(InventoryRepository inventoryRepository, AllocationEngine allocationEngine) {
        this.inventoryRepository = inventoryRepository;
        this.allocationEngine = allocationEngine;
    }

    /**
     * Allocate vehicles according to the request. Returns allocation id.
     */
    public Long allocate(AllocationRequestDto request) {
        if (request == null) throw new IllegalArgumentException("request is required");

        List<Vehicle> available = inventoryRepository.findAvailableVehicles(request.getVehicleType());
        if (available == null) available = Collections.emptyList();

        int demand = Math.max(0, request.getDemand());
        if (available.size() < demand) {
            throw new IllegalStateException("Not enough vehicles available");
        }

        List<Long> allocatedIds = new ArrayList<>();
        for (int i = 0; i < demand; i++) {
            Vehicle v = available.get(i);
            v.setStatus("allocated");
            allocatedIds.add(v.getId());
        }

        Long id = allocationIdCounter.getAndIncrement();
        allocations.put(id, allocatedIds);
        return id;
    }

    /**
     * Return the list of allocated vehicle ids for the allocation id (or null if none).
     */
    public List<Long> getAllocationById(Long allocationId) {
        return allocations.get(allocationId);
    }

    /**
     * Deallocate the vehicles for an allocation id.
     */
    public boolean deallocateVehicle(Long allocationId) {
        List<Long> vehicleIds = allocations.remove(allocationId);
        if (vehicleIds == null) return false;

        // best-effort: mark vehicles available again when possible
        try {
            List<Vehicle> allocatedVehicles = inventoryRepository.findAllocatedVehicles();
            if (allocatedVehicles != null) {
                for (Vehicle v : allocatedVehicles) {
                    if (vehicleIds.contains(v.getId())) {
                        v.setStatus("available");
                    }
                }
            }
        } catch (Exception ignored) {
            // repository methods might not be fully implemented yet; this is best-effort
        }
        return true;
    }
}