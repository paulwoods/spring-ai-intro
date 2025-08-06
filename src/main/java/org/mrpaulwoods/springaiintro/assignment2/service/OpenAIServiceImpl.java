package org.mrpaulwoods.springaiintro.assignment2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.assignment2.functions.StockFunction;
import org.mrpaulwoods.springaiintro.assignment2.model.Answer;
import org.mrpaulwoods.springaiintro.assignment2.model.Question;
import org.mrpaulwoods.springaiintro.assignment2.model.StockPriceRequest;
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
                        FunctionToolCallback.builder("StockPriceInformation", new StockFunction(apiNinjasKey))
                                .description("Get the current stock price for a stock ticker")
                                .inputType(StockPriceRequest.class)
                                .build())
                .build();

        Message userMessage = new PromptTemplate(question.question()).createMessage();

        Message systemMessage = new SystemPromptTemplate("""
                You are a helpful stock price service.
                Return the requested stock price with a cheerful attitude.
                """).createMessage();

        ChatResponse response = openAiChatModel.call(new Prompt(List.of(systemMessage, userMessage), promptOptions));

        return new Answer(response.getResult().getOutput().getText());
    }

}