package com.example.demoapp.repository;

import com.example.demoapp.model.Resource;
import com.example.demoapp.model.ResourceStatus;
import com.example.demoapp.model.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findResourceByResourceStatusAndResourceTypeAndEnergyGreaterThan(ResourceStatus resourceStatus,
                                                                                 ResourceType resourceType,
                                                                                 Integer minEnergy);

    Resource save(Resource resource );

    default List<Resource> findAvailableResource(ResourceStatus resourceStatus,
                                                 ResourceType resourceType,
                                                 Integer minEnergy) {
        return findResourceByResourceStatusAndResourceTypeAndEnergyGreaterThan(resourceStatus, resourceType, minEnergy);
    }
}
