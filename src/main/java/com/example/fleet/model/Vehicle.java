package com.example.fleet.model;

public class Vehicle {
    private Long id;
    private String model;
    private String status;

    public Vehicle() {
    }

    public Vehicle(Long id, String model, String status) {
        this.id = id;
        this.model = model;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}