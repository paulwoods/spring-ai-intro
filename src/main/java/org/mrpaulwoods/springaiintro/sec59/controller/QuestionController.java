package org.mrpaulwoods.springaiintro.sec59.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.sec59.model.Answer;
import org.mrpaulwoods.springaiintro.sec59.model.Question;
import org.mrpaulwoods.springaiintro.sec59.service.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

    private final OpenAIService openAIService;

    @PostMapping("ask")
    public Answer askQuestion(@RequestBody Question question) {
        return openAIService.getAnswer(question);
    }
}
