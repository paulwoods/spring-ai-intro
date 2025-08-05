package org.mrpaulwoods.springaiintro.sec39.service;

import org.mrpaulwoods.springaiintro.sec39.model.Answer;
import org.mrpaulwoods.springaiintro.sec39.model.Question;

public interface OpenAIService {

    Answer getAnswer(Question question);

}
