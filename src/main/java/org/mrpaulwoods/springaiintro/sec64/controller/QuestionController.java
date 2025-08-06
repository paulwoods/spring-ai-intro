package org.mrpaulwoods.springaiintro.sec64.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.sec64.model.Question;
import org.mrpaulwoods.springaiintro.sec64.service.OpenAIService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

    private final OpenAIService openAIService;

    @PostMapping(value = "image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@RequestBody Question question) {
        return openAIService.getImage(question);
    }
}
