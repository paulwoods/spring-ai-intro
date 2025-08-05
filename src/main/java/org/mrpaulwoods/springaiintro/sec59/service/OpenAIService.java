package org.mrpaulwoods.springaiintro.sec59.service;

import org.mrpaulwoods.springaiintro.sec59.model.Answer;
import org.mrpaulwoods.springaiintro.sec59.model.Question;

public interface OpenAIService {

    Answer getAnswer(Question question);

}
