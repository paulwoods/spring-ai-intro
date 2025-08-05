package org.mrpaulwoods.springaiintro.sec49.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.sec49.model.Answer;
import org.mrpaulwoods.springaiintro.sec49.model.Question;
import org.mrpaulwoods.springaiintro.sec49.service.OpenAIServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

    private final OpenAIServiceImpl openAIServiceImpl;

    @PostMapping("ask")
    public Answer askQuestion(@RequestBody Question question) {
        return openAIServiceImpl.getAnswer(question);
    }
}
