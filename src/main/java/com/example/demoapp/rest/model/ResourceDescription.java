package com.example.demoapp.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceDescription {

    @NotNull
    private Type type;

    @Min( 0 )
    @Max( 100 )
    private Integer energy;
}
