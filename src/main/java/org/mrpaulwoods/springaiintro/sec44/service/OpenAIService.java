package org.mrpaulwoods.springaiintro.sec44.service;

import org.mrpaulwoods.springaiintro.sec44.model.Answer;
import org.mrpaulwoods.springaiintro.sec44.model.Question;

public interface OpenAIService {

    Answer getAnswer(Question question);

}
