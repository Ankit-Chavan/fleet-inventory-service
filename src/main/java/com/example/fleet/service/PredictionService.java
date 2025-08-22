package com.example.fleet.service;

import com.example.fleet.ml.Predictor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionService {

    private final Predictor predictor;

    @Autowired
    public PredictionService(Predictor predictor) {
        this.predictor = predictor;
    }

    public double predictInventoryNeeds(String vehicleType, List<Double> historicalData) {
        return predictor.predict(vehicleType, historicalData);
    }

    public double predictUtilization(String vehicleType, List<Double> usageData) {
        return predictor.predictUtilization(vehicleType, usageData);
    }
}