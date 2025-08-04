package org.mrpaulwoods.springaiintro.sec19.services;

import org.mrpaulwoods.springaiintro.sec19.model.Answer;
import org.mrpaulwoods.springaiintro.sec19.model.Question;

public interface OpenAiService {

    String getAnswer(String question);

    Answer getAnswer(Question question);
}
