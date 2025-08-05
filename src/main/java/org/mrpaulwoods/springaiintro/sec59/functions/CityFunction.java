package org.mrpaulwoods.springaiintro.sec59.functions;

import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.sec59.model.CityRequest;
import org.mrpaulwoods.springaiintro.sec59.model.CityResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.function.Function;

@Slf4j
public class CityFunction implements Function<CityRequest, CityResponse> {

    public static final String CITY_URL = "https://api.api-ninjas.com/v1/city";

    private final String apiNinjasKey;

    public CityFunction(String apiNinjasKey) {
        this.apiNinjasKey = apiNinjasKey;
    }

    @Override
    public CityResponse apply(CityRequest cityRequest) {

        RestClient restClient = RestClient.builder()
                .baseUrl(CITY_URL)
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set("X-Api-Key", apiNinjasKey);
                    httpHeaders.set("Accept", "application/json");
                    httpHeaders.set("Content-Type", "application/json");
                }).build();

        List<CityResponse> responses = restClient.get().uri(uriBuilder -> {

                    log.info("building uri for city function: {}", cityRequest);

                    if (cityRequest.name() != null && !cityRequest.name().isBlank()) {
                        uriBuilder.queryParam("name", cityRequest.name());
                    }

                    if (cityRequest.country() != null && !cityRequest.country().isBlank()) {
                        uriBuilder.queryParam("country", cityRequest.country());
                    }

                    return uriBuilder.build();
                })
                .retrieve()
                .body(new ParameterizedTypeReference<List<CityResponse>>() {
                });

        return responses != null ? responses.getFirst() : null;
    }

}
