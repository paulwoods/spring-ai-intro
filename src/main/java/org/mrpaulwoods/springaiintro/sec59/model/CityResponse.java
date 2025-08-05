package org.mrpaulwoods.springaiintro.sec59.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;

public record CityResponse(
        @JsonPropertyDescription("The name of the city") String name,
        @JsonPropertyDescription("The latitude coordinate") BigDecimal latitude,
        @JsonPropertyDescription("The longitude coordinate") BigDecimal longitude,
        @JsonPropertyDescription("The country") String country,
        @JsonPropertyDescription("The population of the city") Integer population,
        @JsonPropertyDescription("A flag indicating if the city is a capital") Boolean isCapital
) {
}
