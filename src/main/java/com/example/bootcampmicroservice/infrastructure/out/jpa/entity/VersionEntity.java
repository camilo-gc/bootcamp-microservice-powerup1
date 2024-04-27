package com.example.bootcampmicroservice.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "version")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VersionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "bootcamp_id")
    private BootcampEntity bootcampEntity;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer maxCapacity;

}