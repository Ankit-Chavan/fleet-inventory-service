// filepath: src/main/java/com/example/fleet/ml/Predictor.java
package com.example.fleet.ml;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Simple stub predictor to keep the project compilable.
 * Replace with a real ML model integration later.
 */
@Component
public class Predictor {

    public Predictor() {
        // no-op stub
    }

    public double predict(String vehicleType, List<Double> historicalData) {
        if (historicalData == null || historicalData.isEmpty()) return 0.0;
        return historicalData.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double predictUtilization(String vehicleType, List<Double> usageData) {
        if (usageData == null || usageData.isEmpty()) return 0.0;
        // Simple heuristic: normalized average
        double avg = usageData.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        return Math.min(1.0, avg / 100.0); // example: convert usage to fraction
    }
}