package org.mrpaulwoods.springaiintro.sec51.service;

import org.mrpaulwoods.springaiintro.sec51.model.Answer;
import org.mrpaulwoods.springaiintro.sec51.model.Question;

public interface OpenAIService {

    Answer getAnswer(Question question);

}
