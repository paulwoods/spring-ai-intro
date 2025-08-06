package org.mrpaulwoods.springaiintro.sec64.service;

import org.mrpaulwoods.springaiintro.sec64.model.Question;

public interface OpenAIService {

    byte[] getImage(Question question);

}
