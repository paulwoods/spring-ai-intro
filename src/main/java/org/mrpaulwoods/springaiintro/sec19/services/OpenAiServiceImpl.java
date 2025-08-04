package org.mrpaulwoods.springaiintro.sec19.services;

import org.mrpaulwoods.springaiintro.sec19.model.Answer;
import org.mrpaulwoods.springaiintro.sec19.model.Question;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class OpenAiServiceImpl implements OpenAiService {

    private final ChatModel chatModel;

    public OpenAiServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public Answer getAnswer(Question question) {
        System.out.println("I was called with: " + question.question());
        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatModel.call(prompt);
        Answer answer = new Answer(response.getResult().getOutput().getText());
        System.out.println("I returned: " + answer.answer() + "\n\n");
        return answer;
    }

    @Override
    public String getAnswer(String question) {
        PromptTemplate promptTemplate = new PromptTemplate(question);
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatModel.call(prompt);
        return response.getResult().getOutput().getText();
    }


}
