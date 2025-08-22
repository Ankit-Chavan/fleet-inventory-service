package com.example.fleet.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // logical vehicle type, e.g. "truck", "car", "van"
    @Column(name = "type", nullable = false)
    private String type;

    // size category, e.g. "small", "medium", "large" or number of axles
    @Column(name = "size_category")
    private String sizeCategory;

    // capacity in units (e.g., cubic meters or a simple integer capacity)
    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "status")
    private String status;

    public Vehicle() {
    }

    public Vehicle(String type, String sizeCategory, Integer capacity, String status) {
        this.type = type;
        this.sizeCategory = sizeCategory;
        this.capacity = capacity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSizeCategory() {
        return sizeCategory;
    }

    public void setSizeCategory(String sizeCategory) {
        this.sizeCategory = sizeCategory;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}