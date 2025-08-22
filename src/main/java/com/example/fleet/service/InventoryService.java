package com.example.fleet.service;

import com.example.fleet.dto.InventoryDto;
import com.example.fleet.model.InventoryItem;
import com.example.fleet.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryItem addInventoryItem(InventoryDto inventoryDto) {
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setName(inventoryDto.getName());
        inventoryItem.setQuantity(inventoryDto.getQuantity());
        return inventoryRepository.save(inventoryItem);
    }

    public Optional<InventoryItem> updateInventoryItem(Long id, InventoryDto inventoryDto) {
        return inventoryRepository.findById(id).map(item -> {
            item.setName(inventoryDto.getName());
            item.setQuantity(inventoryDto.getQuantity());
            return inventoryRepository.save(item);
        });
    }

    public List<InventoryItem> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    public Optional<InventoryItem> getInventoryItemById(Long id) {
        return inventoryRepository.findById(id);
    }

    public void deleteInventoryItem(Long id) {
        inventoryRepository.deleteById(id);
    }
}