package org.mrpaulwoods.springaiintro.sec66.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.sec66.model.Question;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@Slf4j
@RequiredArgsConstructor
public class OpenAIServiceImpl implements OpenAIService {

    private final OpenAiImageModel imageModel;

    @Override
    public byte[] getImage(Question question) {

        var options = OpenAiImageOptions.builder()
                .height(1024)
                .width(1024)
                .responseFormat("b64_json")
                .model("dall-e-3") // default is "dall-e-2"
                .quality("hd")  // standard (default), hd   - for dall-e-3
                .style("vivid") // vivid (default), natural
                .build();

        // https://platform.openai.com/docs/api-reference/images/create
        // https://help.openai.com/en/articles/8555480-dalle-3-api

        ImagePrompt imagePrompt = new ImagePrompt(question.question(), options);
        var imageResponse = imageModel.call(imagePrompt);
        return Base64.getDecoder().decode(imageResponse.getResult().getOutput().getB64Json());
    }

}
