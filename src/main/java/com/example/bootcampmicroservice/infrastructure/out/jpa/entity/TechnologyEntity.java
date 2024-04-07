package com.example.bootcampmicroservice.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "technologies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TechnologyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "name_technology")
    private String name;
    private String description;

    //ejemplo
    /*@ManyToOne
    @JoinColumn(name = "system_id")
    private SystemEntity so;*/
}