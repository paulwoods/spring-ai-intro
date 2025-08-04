package org.mrpaulwoods.springaiintro.sec22.services;

import org.mrpaulwoods.springaiintro.sec22.model.Answer;
import org.mrpaulwoods.springaiintro.sec22.model.GetCapitalRequest;
import org.mrpaulwoods.springaiintro.sec22.model.Question;

public interface OpenAiService {

    String getAnswer(String question);

    Answer getAnswer(Question question);

    Answer getCapital(GetCapitalRequest getCapitalRequest);

    Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest);
}
