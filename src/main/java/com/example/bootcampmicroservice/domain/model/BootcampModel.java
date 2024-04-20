package com.example.bootcampmicroservice.domain.model;

import java.util.Set;

public class BootcampModel {

    private Long id;
    private String name;
    private String description;
    private Set<CapacityModel> capacities;

    public BootcampModel(Long id, String name, String description, Set<CapacityModel> capacities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacities = capacities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CapacityModel> getCapacities() {
        return capacities;
    }

    public void setCapacities(Set<CapacityModel> capacities) {
        this.capacities = capacities;
    }
}