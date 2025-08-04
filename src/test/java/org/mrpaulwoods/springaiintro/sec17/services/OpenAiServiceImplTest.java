package org.mrpaulwoods.springaiintro.sec17.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenAiServiceImplTest {

    @Autowired
    OpenAiServiceImpl openAiService;

    @Test
    void getAnswer() {
        String answer = openAiService.getAnswer("What is the meaning of life?");
        System.out.println(answer);
    }

}