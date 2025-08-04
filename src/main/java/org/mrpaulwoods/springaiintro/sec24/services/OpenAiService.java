package org.mrpaulwoods.springaiintro.sec24.services;

import org.mrpaulwoods.springaiintro.sec24.model.Answer;
import org.mrpaulwoods.springaiintro.sec24.model.GetCapitalRequest;
import org.mrpaulwoods.springaiintro.sec24.model.GetCapitalResponse;
import org.mrpaulwoods.springaiintro.sec24.model.Question;

public interface OpenAiService {

    String getAnswer(String question);

    Answer getAnswer(Question question);

    GetCapitalResponse getCapital(GetCapitalRequest getCapitalRequest);

    Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest);
}
