package org.mrpaulwoods.springaiintro.assignment2.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;

public record StockPriceResponse(
        @JsonPropertyDescription("The stock's ticker symbol in uppercase") String ticker,
        @JsonPropertyDescription("The full name of the company.") String name,
        @JsonPropertyDescription("The current price of the stock") BigDecimal price,
        @JsonPropertyDescription("The name of the stock market exchange") String exchange,
        @JsonPropertyDescription("The updated date, in epoch") Long updated,
        @JsonPropertyDescription("The code name of the currency") String currency
) {
}
