package com.example.bootcampmicroservice.domain.model;

import java.time.LocalDate;

public class VersionModel {
    private Long id;
    private BootcampModel bootcamp;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer maxCapacity;

    public VersionModel(Long id, BootcampModel bootcamp, LocalDate startDate, LocalDate endDate, Integer maxCapacity) {
        this.id = id;
        this.bootcamp = bootcamp;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxCapacity = maxCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BootcampModel getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(BootcampModel bootcamp) {
        this.bootcamp = bootcamp;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}