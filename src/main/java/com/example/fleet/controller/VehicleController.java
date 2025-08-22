package com.example.fleet.controller;

import com.example.fleet.dto.VehicleDto;
import com.example.fleet.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> create(@RequestBody VehicleDto dto) {
        VehicleDto created = vehicleService.createVehicle(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public List<VehicleDto> listAll() {
        return vehicleService.listAll();
    }

    @GetMapping("/search")
    public List<VehicleDto> search(@RequestParam String type, @RequestParam String status) {
        return vehicleService.listByTypeAndStatus(type, status);
    }
}
