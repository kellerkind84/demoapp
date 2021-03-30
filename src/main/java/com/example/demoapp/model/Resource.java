package com.example.demoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Resource {

    private Long id;

    private Integer energy;
    private ResourceStatus resourceStatus;
    private ResourceType resourceType;

}
