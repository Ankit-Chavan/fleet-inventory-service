package com.example.fleet.controller;

import com.example.fleet.dto.AllocationRequestDto;
import com.example.fleet.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/allocations")
public class AllocationController {

    private final AllocationService allocationService;

    @Autowired
    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @PostMapping
    public ResponseEntity<?> allocateVehicle(@RequestBody AllocationRequestDto allocationRequest) {
        return ResponseEntity.ok(allocationService.allocateVehicle(allocationRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllocation(@PathVariable Long id) {
        return ResponseEntity.ok(allocationService.getAllocationById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deallocateVehicle(@PathVariable Long id) {
        allocationService.deallocateVehicle(id);
        return ResponseEntity.noContent().build();
    }
}