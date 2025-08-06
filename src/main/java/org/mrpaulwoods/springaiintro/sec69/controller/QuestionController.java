package org.mrpaulwoods.springaiintro.sec69.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.sec69.model.Question;
import org.mrpaulwoods.springaiintro.sec69.service.OpenAIService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

    private final OpenAIService openAIService;

    @PostMapping(value = "image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@RequestBody Question question) {
        return openAIService.getImage(question);
    }

    @PostMapping(value = "vision", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String upload(@Validated @RequestParam("file") MultipartFile file,
                         @RequestParam("name") String name) {

        return openAIService.getDescription(file);

    }
}
