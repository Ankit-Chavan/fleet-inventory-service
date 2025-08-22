package com.example.fleet.dto;

import com.example.fleet.model.InventoryItem;

// ...existing code...
public class InventoryDto {
    private Long id;
    private String name;
    private String vehicleType;
    private int quantity;

    public InventoryDto() {}

    public InventoryDto(Long id, String name, String vehicleType, int quantity) {
        this.id = id;
        this.name = name;
        this.vehicleType = vehicleType;
        this.quantity = quantity;
    }

    public static InventoryDto fromEntity(InventoryItem item) {
        if (item == null) return null;
        return new InventoryDto(
            item.getId(),
            item.getName(),
            item.getVehicleType(),
            item.getQuantity()
        );
    }

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}