package com.example.demoapp.rest.mapper;

import com.example.demoapp.model.Resource;
import com.example.demoapp.rest.model.ResourceDescription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResourceMapper {

    @Mapping(target = "type", source = "resourceType")
    ResourceDescription map(Resource resource);
}
