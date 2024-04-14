package com.example.bootcampmicroservice.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "capacities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CapacityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "capacities_technologies",
            joinColumns = @JoinColumn(name = "capacity_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private Set<TechnologyEntity> technologiesEntity;

}