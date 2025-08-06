package org.mrpaulwoods.springaiintro.assignment2.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonClassDescription("Stock Price Request")
public record StockPriceRequest(
        @JsonProperty(required = true)
        @JsonPropertyDescription("The stock's ticker symbol, in uppercase")
        String ticker
) {
}
