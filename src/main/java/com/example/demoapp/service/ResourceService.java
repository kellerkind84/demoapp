package com.example.demoapp.service;

import com.example.demoapp.model.Resource;
import com.example.demoapp.model.ResourceStatus;
import com.example.demoapp.repository.IResourceRepository;
import com.example.demoapp.rest.mapper.TypeMapper;
import com.example.demoapp.rest.model.ResourceDescription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final IResourceRepository resourceRepository;
    private final TypeMapper typeMapper;

    public Resource startSession(ResourceDescription resourceDescription) {
        List<Resource> matchingResources =
                resourceRepository.findAvailableResource(
                        ResourceStatus.FREE,
                        typeMapper.map(resourceDescription.getType()),
                        resourceDescription.getEnergy());

        Optional<Resource> resource = matchingResources.stream()
                .max(Comparator.comparingInt(Resource::getEnergy));

        if (resource.isPresent()) {
            resource.get().setResourceStatus(ResourceStatus.IN_USE);
            resourceRepository.save(resource.get());
            return resource.get();
        } else {
            return null;
        }
    }
}
