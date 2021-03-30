package com.example.demoapp.repository;

import com.example.demoapp.model.Resource;
import com.example.demoapp.model.ResourceStatus;
import com.example.demoapp.model.ResourceType;
import com.example.demoapp.db.Resources;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ResourceRepository implements IResourceRepository {

    private List<Resource> resources = Resources.getResources();


    @Override
    public List<Resource> findResourceByResourceStatusAndResourceTypeAndEnergyGreaterThan(
            ResourceStatus resourceStatus, ResourceType resourceType, Integer minEnergy) {
        return resources.stream()
                .filter( resource -> resource.getResourceStatus().equals(resourceStatus))
                .filter( resource -> resource.getResourceType().equals(resourceType))
                .filter( resource -> resource.getEnergy() > minEnergy )
                .collect(Collectors.toList());
    }

    @Override
    public void save(Resource resource) {
        Optional<Resource> res = resources.stream()
                .filter(r -> r.getId().equals(resource.getId())).findFirst();
        if (res.isEmpty()) {
            throw new RuntimeException();
        }
        res.get().setResourceType(resource.getResourceType());
        res.get().setResourceStatus(resource.getResourceStatus());
        res.get().setEnergy(resource.getEnergy());
    }
}
