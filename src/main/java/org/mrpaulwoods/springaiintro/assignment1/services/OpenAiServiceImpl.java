package org.mrpaulwoods.springaiintro.assignment1.services;

import org.mrpaulwoods.springaiintro.assignment1.model.*;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class OpenAiServiceImpl implements OpenAiService {

    private final ChatModel chatModel;
    private final Resource getCapitalPrompt;
    private final Resource getCapitalWithInfoPrompt;

    public OpenAiServiceImpl(
            ChatModel chatModel,
            @Value("classpath:templates/assignment1/get-capital-prompt.st") Resource getCapitalPrompt,
            @Value("classpath:templates/assignment1/get-capital-with-info.st") Resource getCapitalWithInfoPrompt
    ) {
        this.chatModel = chatModel;
        this.getCapitalPrompt = getCapitalPrompt;
        this.getCapitalWithInfoPrompt = getCapitalWithInfoPrompt;
    }

    @Override
    public Answer getAnswer(Question question) {
        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatModel.call(prompt);
        return new Answer(response.getResult().getOutput().getText());
    }

    @Override
    public GetCapitalResponse getCapital(GetCapitalRequest getCapitalRequest) {
        BeanOutputConverter<GetCapitalResponse> converter = new BeanOutputConverter<>(GetCapitalResponse.class);
        String format = converter.getFormat();

        // System.out.println("format: \n" + format);

        Prompt prompt = new PromptTemplate(getCapitalPrompt).create(
                Map.of(
                        "stateOrCountry", getCapitalRequest.stateOrCountry(),
                        "format", format
                )
        );

        ChatResponse response = chatModel.call(prompt);
        return converter.convert(Objects.requireNonNull(response.getResult().getOutput().getText()));
    }

    @Override
    public CapitalInfoResponse getCapitalWithInfo(GetCapitalRequest getCapitalRequest) {
        BeanOutputConverter<CapitalInfoResponse> converter = new BeanOutputConverter<>(CapitalInfoResponse.class);
        String format = converter.getFormat();
        PromptTemplate promptTemplate = new PromptTemplate(getCapitalWithInfoPrompt);
        Prompt prompt = promptTemplate.create(Map.of(
                "stateOrCountry", getCapitalRequest.stateOrCountry(),
                "format", format
        ));
        ChatResponse response = chatModel.call(prompt);
        return converter.convert(Objects.requireNonNull(response.getResult().getOutput().getText()));
    }

    @Override
    public String getAnswer(String question) {
        PromptTemplate promptTemplate = new PromptTemplate(question);
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatModel.call(prompt);
        return response.getResult().getOutput().getText();
    }

}
