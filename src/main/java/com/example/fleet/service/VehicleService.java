package com.example.fleet.service;

import com.example.fleet.dto.VehicleDto;
import com.example.fleet.model.Vehicle;
import com.example.fleet.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleDto createVehicle(VehicleDto dto) {
        Vehicle v = new Vehicle(dto.getType(), dto.getSizeCategory(), dto.getCapacity(), dto.getStatus());
        Vehicle saved = vehicleRepository.save(v);
        return VehicleDto.fromEntity(saved);
    }

    public List<VehicleDto> listAll() {
        return vehicleRepository.findAll().stream().map(VehicleDto::fromEntity).collect(Collectors.toList());
    }

    public List<VehicleDto> listByTypeAndStatus(String type, String status) {
        return vehicleRepository.findByTypeAndStatus(type, status).stream().map(VehicleDto::fromEntity).collect(Collectors.toList());
    }
}
