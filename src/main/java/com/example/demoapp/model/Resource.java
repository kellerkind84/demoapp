package com.example.demoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer energy;
    @Enumerated(EnumType.STRING)
    private ResourceStatus resourceStatus;
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

}
