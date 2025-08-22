package com.example.fleet.controller;

import com.example.fleet.dto.InventoryDto;
import com.example.fleet.model.InventoryItem;
import com.example.fleet.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

// ...existing code...
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping
    public List<InventoryDto> listAll() {
        List<InventoryItem> items = inventoryRepository.findAll();
        return items.stream().map(InventoryDto::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDto> getById(@PathVariable Long id) {
        return inventoryRepository.findById(id)
                .map(InventoryDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}