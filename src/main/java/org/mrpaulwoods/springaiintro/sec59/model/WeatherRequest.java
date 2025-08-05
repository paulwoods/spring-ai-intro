package org.mrpaulwoods.springaiintro.sec59.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonClassDescription("Weather API Request")
public record WeatherRequest(

        @JsonProperty(required = true)
        @JsonPropertyDescription("The latitude of the city")
        BigDecimal lat,

        @JsonProperty(required = true)
        @JsonPropertyDescription("The longitude of the city")
        BigDecimal lon
) {
}
