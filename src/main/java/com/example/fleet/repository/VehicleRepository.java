package com.example.fleet.repository;

import com.example.fleet.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByTypeAndStatus(String type, String status);
    List<Vehicle> findByStatus(String status);
}
