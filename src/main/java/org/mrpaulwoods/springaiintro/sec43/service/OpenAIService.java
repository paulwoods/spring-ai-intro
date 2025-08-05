package org.mrpaulwoods.springaiintro.sec43.service;

import org.mrpaulwoods.springaiintro.sec43.model.Answer;
import org.mrpaulwoods.springaiintro.sec43.model.Question;

public interface OpenAIService {

    Answer getAnswer(Question question);

}
