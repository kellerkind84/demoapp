package com.example.demoapp.dbsetup;

import com.example.demoapp.model.Resource;
import com.example.demoapp.repository.IResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.example.demoapp.model.ResourceStatus.FREE;
import static com.example.demoapp.model.ResourceStatus.IN_USE;
import static com.example.demoapp.model.ResourceType.ROVER;
import static com.example.demoapp.model.ResourceType.SATELLITE;

@RequiredArgsConstructor
@Component
public class ResourcesDbSetupService {

    private final IResourceRepository resourceRepository;

    @PostConstruct
    public void saveResources() {
        resourceRepository.save(new Resource(1L, 70, IN_USE, SATELLITE));
        resourceRepository.save(new Resource(2L, 90, FREE, SATELLITE));
        resourceRepository.save(new Resource(3L, 70, FREE, SATELLITE));
        resourceRepository.save(new Resource(4L, 70, FREE, ROVER));
        resourceRepository.save(new Resource(5L, 70, IN_USE, ROVER));
        resourceRepository.save(new Resource(6L, 90, FREE, ROVER));
    }
}
