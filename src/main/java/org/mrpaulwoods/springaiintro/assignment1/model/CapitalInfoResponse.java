package org.mrpaulwoods.springaiintro.assignment1.model;

public record CapitalInfoResponse(
        String city,
        String population,
        String region,
        String language,
        String currency
) {
}
