package org.mrpaulwoods.springaiintro.sec41.service;

import org.mrpaulwoods.springaiintro.sec41.model.Answer;
import org.mrpaulwoods.springaiintro.sec41.model.Question;

public interface OpenAIService {

    Answer getAnswer(Question question);

}
