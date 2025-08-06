package org.mrpaulwoods.springaiintro.sec73.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.sec19.model.Question;
import org.mrpaulwoods.springaiintro.sec73.service.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

    private final OpenAIService openAIService;

    @PostMapping(value = "talk", produces = "audio/mpeg")
    public byte[] talk(@RequestBody Question question) {
        return openAIService.getSpeech(question);
    }

}
