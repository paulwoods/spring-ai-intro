package org.mrpaulwoods.springaiintro.sec64.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.sec64.model.Question;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@Slf4j
@RequiredArgsConstructor
public class OpenAIServiceImpl implements OpenAIService {

    private final ImageModel imageModel;

    @Override
    public byte[] getImage(Question question) {

        var options = ImageOptionsBuilder.builder()
                .height(1024)
                .width(1024)
                .responseFormat("b64_json")
                .model("dall-e-3") // default is "dall-e-2"
                .build();

        ImagePrompt imagePrompt = new ImagePrompt(question.question(), options);
        var imageResponse = imageModel.call(imagePrompt);
        return Base64.getDecoder().decode(imageResponse.getResult().getOutput().getB64Json());
    }

}
