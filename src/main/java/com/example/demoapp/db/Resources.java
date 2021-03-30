package com.example.demoapp.db;

import com.example.demoapp.model.Resource;

import java.util.List;

import static com.example.demoapp.model.ResourceStatus.FREE;
import static com.example.demoapp.model.ResourceStatus.IN_USE;
import static com.example.demoapp.model.ResourceType.ROVER;
import static com.example.demoapp.model.ResourceType.SATELLITE;

public class Resources {

    public static List<Resource> getResources() {
        return List.of(
                new Resource( 1L, 70, FREE, SATELLITE),
                new Resource( 1L, 90, FREE, SATELLITE),
                new Resource( 1L, 70, IN_USE, SATELLITE),
                new Resource( 1L, 70, FREE, ROVER),
                new Resource( 1L, 70, IN_USE, ROVER),
                new Resource( 1L, 90, FREE, ROVER)
        );
    }
}
