package org.mrpaulwoods.springaiintro.sec42.service;

import org.mrpaulwoods.springaiintro.sec42.model.Answer;
import org.mrpaulwoods.springaiintro.sec42.model.Question;

public interface OpenAIService {

    Answer getAnswer(Question question);

}
