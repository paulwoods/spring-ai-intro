package org.mrpaulwoods.springaiintro.sec24.controllers;

import org.mrpaulwoods.springaiintro.sec24.model.Answer;
import org.mrpaulwoods.springaiintro.sec24.model.GetCapitalRequest;
import org.mrpaulwoods.springaiintro.sec24.model.GetCapitalResponse;
import org.mrpaulwoods.springaiintro.sec24.model.Question;
import org.mrpaulwoods.springaiintro.sec24.services.OpenAiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class QuestionController {

    private final OpenAiService openAiService;

    public QuestionController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping("capitalWithInfo")
    public Answer getCapitalWithInfo(@RequestBody GetCapitalRequest getCapitalRequest) {
        return this.openAiService.getCapitalWithInfo(getCapitalRequest);
    }

    @PostMapping("capital")
    public GetCapitalResponse getCapital(@RequestBody GetCapitalRequest getCapitalRequest) {
        return this.openAiService.getCapital(getCapitalRequest);
    }

    @PostMapping("ask")
    public Answer askQuestion(@RequestBody Question question) {
        return this.openAiService.getAnswer(question);
    }

}
