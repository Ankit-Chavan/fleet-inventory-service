package com.example.fleet.util;

import org.springframework.stereotype.Component;

@Component
public class Metrics {

    private long inventoryCount;
    private long allocationCount;

    public Metrics() {
        this.inventoryCount = 0;
        this.allocationCount = 0;
    }

    public void incrementInventoryCount() {
        inventoryCount++;
    }

    public void incrementAllocationCount() {
        allocationCount++;
    }

    public long getInventoryCount() {
        return inventoryCount;
    }

    public long getAllocationCount() {
        return allocationCount;
    }

    public void resetMetrics() {
        inventoryCount = 0;
        allocationCount = 0;
    }

    public String getMetricsSummary() {
        return String.format("Inventory Count: %d, Allocation Count: %d", inventoryCount, allocationCount);
    }
}