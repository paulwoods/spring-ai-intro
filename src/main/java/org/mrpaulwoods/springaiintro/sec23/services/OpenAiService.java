package org.mrpaulwoods.springaiintro.sec23.services;

import org.mrpaulwoods.springaiintro.sec23.model.Answer;
import org.mrpaulwoods.springaiintro.sec23.model.GetCapitalRequest;
import org.mrpaulwoods.springaiintro.sec23.model.Question;

public interface OpenAiService {

    String getAnswer(String question);

    Answer getAnswer(Question question);

    Answer getCapital(GetCapitalRequest getCapitalRequest);

    Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest);
}
