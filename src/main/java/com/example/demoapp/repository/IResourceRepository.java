package com.example.demoapp.repository;

import com.example.demoapp.model.Resource;
import com.example.demoapp.model.ResourceStatus;
import com.example.demoapp.model.ResourceType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IResourceRepository {

    List<Resource> findResourceByResourceStatusAndResourceTypeAndEnergyGreaterThan(ResourceStatus resourceStatus,
                                                                                 ResourceType resourceType,
                                                                                 Integer minEnergy);

    void save( Resource resource );

    default List<Resource> findAvailableResource(ResourceStatus resourceStatus,
                                                 ResourceType resourceType,
                                                 Integer minEnergy) {
        return findResourceByResourceStatusAndResourceTypeAndEnergyGreaterThan(resourceStatus, resourceType, minEnergy);
    }
}
