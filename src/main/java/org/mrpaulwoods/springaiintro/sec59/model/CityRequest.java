package org.mrpaulwoods.springaiintro.sec59.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonClassDescription("City Information Request")
public record CityRequest(

        @JsonProperty(required = true, value = "name")
        @JsonPropertyDescription("The name of the city, e.g. Dallas")
        String name,

        @JsonProperty(required = true, value = "country")
        @JsonPropertyDescription("The name of the country as ISO-3166 2 character code, e.g. US")
        String country
) {
}
