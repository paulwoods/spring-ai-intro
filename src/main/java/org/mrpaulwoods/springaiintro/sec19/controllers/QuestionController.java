package org.mrpaulwoods.springaiintro.sec19.controllers;

import org.mrpaulwoods.springaiintro.sec19.model.Answer;
import org.mrpaulwoods.springaiintro.sec19.model.Question;
import org.mrpaulwoods.springaiintro.sec19.services.OpenAiService;
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

    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Question question) {
        return openAiService.getAnswer(question);
    }

}
