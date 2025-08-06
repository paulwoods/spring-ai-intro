package org.mrpaulwoods.springaiintro.sec73.service;

import org.mrpaulwoods.springaiintro.sec19.model.Question;

public interface OpenAIService {

    byte[] getSpeech(Question question);

}
