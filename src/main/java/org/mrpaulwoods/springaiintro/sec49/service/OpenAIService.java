package org.mrpaulwoods.springaiintro.sec49.service;

import org.mrpaulwoods.springaiintro.sec49.model.Answer;
import org.mrpaulwoods.springaiintro.sec49.model.Question;

public interface OpenAIService {

    Answer getAnswer(Question question);

}
