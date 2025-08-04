package org.mrpaulwoods.springaiintro.sec20.services;

import org.mrpaulwoods.springaiintro.sec20.model.Answer;
import org.mrpaulwoods.springaiintro.sec20.model.GetCapitalRequest;
import org.mrpaulwoods.springaiintro.sec20.model.Question;

public interface OpenAiService {

    String getAnswer(String question);

    Answer getAnswer(Question question);

    Answer getCapital(GetCapitalRequest getCapitalRequest);

}
