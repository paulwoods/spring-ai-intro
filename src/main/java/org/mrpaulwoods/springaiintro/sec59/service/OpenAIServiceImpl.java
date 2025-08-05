package org.mrpaulwoods.springaiintro.sec59.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.sec59.functions.CityFunction;
import org.mrpaulwoods.springaiintro.sec59.functions.WeatherFunction;
import org.mrpaulwoods.springaiintro.sec59.model.Answer;
import org.mrpaulwoods.springaiintro.sec59.model.CityRequest;
import org.mrpaulwoods.springaiintro.sec59.model.Question;
import org.mrpaulwoods.springaiintro.sec59.model.WeatherRequest;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OpenAIServiceImpl implements OpenAIService {

    private final OpenAiChatModel openAiChatModel;
    @Value("${sfg.aiapp.apiNinjasKey}")
    private String apiNinjasKey;

    @Override
    public Answer getAnswer(Question question) {

        var promptOptions = OpenAiChatOptions.builder()

                .toolCallbacks(
                        // this gets the city's lat/long
                        FunctionToolCallback.builder("CityInformation", new CityFunction(apiNinjasKey))
                                .description("Get information for a city")
                                .inputType(CityRequest.class)
                                .build(),

                        // this gets the weather for the lat/long
                        FunctionToolCallback.builder("CurrentWeather", new WeatherFunction(apiNinjasKey))
                                .description("Get the current weather for a location")
                                .inputType(WeatherRequest.class)
                                .build())
                .build();

        Message userMessage = new PromptTemplate(question.question()).createMessage();

        Message systemMessage = new SystemPromptTemplate("""
                You are a weather service.
                You receive weather information from a service which gives you the information based on the metrics system.
                When answering the weather in an imperial system country, you should convert the temperature to Fahrenheit and the wind speed to miles per hour.
                """).createMessage();

        ChatResponse response = openAiChatModel.call(new Prompt(List.of(systemMessage, userMessage), promptOptions));

        return new Answer(response.getResult().getOutput().getText());
    }

}
