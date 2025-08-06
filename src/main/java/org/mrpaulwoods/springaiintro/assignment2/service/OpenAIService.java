package org.mrpaulwoods.springaiintro.assignment2.service;

import org.mrpaulwoods.springaiintro.assignment2.model.Answer;
import org.mrpaulwoods.springaiintro.assignment2.model.Question;

public interface OpenAIService {

    Answer getAnswer(Question question);

}
