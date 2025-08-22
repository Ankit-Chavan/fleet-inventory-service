package com.example.fleet.dto;

import com.example.fleet.model.Vehicle;

public class VehicleDto {
    private Long id;
    private String type;
    private String sizeCategory;
    private Integer capacity;
    private String status;

    public VehicleDto() {}

    public VehicleDto(Long id, String type, String sizeCategory, Integer capacity, String status) {
        this.id = id;
        this.type = type;
        this.sizeCategory = sizeCategory;
        this.capacity = capacity;
        this.status = status;
    }

    public static VehicleDto fromEntity(Vehicle v) {
        if (v == null) return null;
        return new VehicleDto(v.getId(), v.getType(), v.getSizeCategory(), v.getCapacity(), v.getStatus());
    }

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getSizeCategory() { return sizeCategory; }
    public void setSizeCategory(String sizeCategory) { this.sizeCategory = sizeCategory; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
