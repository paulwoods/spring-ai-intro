package org.mrpaulwoods.springaiintro.assignment2.functions;

import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.assignment2.model.StockPriceRequest;
import org.mrpaulwoods.springaiintro.assignment2.model.StockPriceResponse;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.util.function.Function;

@Slf4j
public class StockFunction implements Function<StockPriceRequest, StockPriceResponse> {

    public static final String CITY_URL = "https://api.api-ninjas.com/v1/stockprice";

    private final String apiNinjasKey;

    public StockFunction(String apiNinjasKey) {
        this.apiNinjasKey = apiNinjasKey;
    }

    @Override
    public StockPriceResponse apply(StockPriceRequest stockPriceRequest) {

        RestClient restClient = RestClient.builder()
                .baseUrl(CITY_URL)
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set("X-Api-Key", apiNinjasKey);
                    httpHeaders.set("Accept", "application/json");
                    httpHeaders.set("Content-Type", "application/json");
                }).build();

        try {
            return restClient.get().uri(uriBuilder -> {

                        log.info("building uri for stock price function: {}", stockPriceRequest);

                        uriBuilder.queryParam("ticker", stockPriceRequest.ticker());

                        return uriBuilder.build();
                    })
                    .retrieve()
                    .body(StockPriceResponse.class);
        } catch (Exception e) {
            log.warn("error getting stock price", e);
            return new StockPriceResponse("Unknown", "Unknown", BigDecimal.ZERO, "Unknown", 0L, "Unknown");
        }
    }

}
