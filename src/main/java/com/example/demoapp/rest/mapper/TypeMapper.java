package com.example.demoapp.rest.mapper;

import com.example.demoapp.model.ResourceType;
import com.example.demoapp.rest.model.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    ResourceType map(Type type);
}
