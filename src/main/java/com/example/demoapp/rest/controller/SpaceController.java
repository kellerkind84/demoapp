package com.example.demoapp.rest.controller;

import com.example.demoapp.rest.mapper.ResourceMapper;
import com.example.demoapp.rest.model.ResourceDescription;
import com.example.demoapp.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SpaceController {

    private final ResourceService resourceService;
    private final ResourceMapper resourceMapper;

    // start SpaceSession
    @PostMapping("/start")
    public ResourceDescription startSession(@Valid @RequestBody ResourceDescription resourceDescription) {
        return resourceMapper.map(resourceService.startSession(resourceDescription));
    }

}
