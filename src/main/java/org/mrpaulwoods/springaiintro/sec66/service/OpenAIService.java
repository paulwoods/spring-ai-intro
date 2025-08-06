package org.mrpaulwoods.springaiintro.sec66.service;

import org.mrpaulwoods.springaiintro.sec66.model.Question;

public interface OpenAIService {

    byte[] getImage(Question question);

}
