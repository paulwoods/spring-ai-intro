package org.mrpaulwoods.springaiintro.sec59.functions;

import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.sec59.model.WeatherRequest;
import org.mrpaulwoods.springaiintro.sec59.model.WeatherResponse;
import org.springframework.web.client.RestClient;

import java.util.function.Function;

@Slf4j
public class WeatherFunction implements Function<WeatherRequest, WeatherResponse> {

    public static final String WEATHER_URL = "https://api.api-ninjas.com/v1/weather";

    private final String apiNinjasKey;

    public WeatherFunction(String apiNinjasKey) {
        this.apiNinjasKey = apiNinjasKey;
    }

    @Override
    public WeatherResponse apply(WeatherRequest weatherRequest) {
        RestClient restClient = RestClient.builder()
                .baseUrl(WEATHER_URL)
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set("X-Api-Key", apiNinjasKey);
                    httpHeaders.set("Accept", "application/json");
                    httpHeaders.set("Content-Type", "application/json");
                }).build();

        return restClient.get().uri(uriBuilder -> {

                    log.info("building uri for weather function: {}", weatherRequest);

                    uriBuilder.queryParam("lat", weatherRequest.lat());

                    uriBuilder.queryParam("lon", weatherRequest.lon());

                    return uriBuilder.build();
                })
                .retrieve()
                .body(WeatherResponse.class);
    }

}
