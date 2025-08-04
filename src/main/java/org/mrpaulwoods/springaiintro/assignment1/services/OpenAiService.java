package org.mrpaulwoods.springaiintro.assignment1.services;

import org.mrpaulwoods.springaiintro.assignment1.model.*;

public interface OpenAiService {

    String getAnswer(String question);

    Answer getAnswer(Question question);

    GetCapitalResponse getCapital(GetCapitalRequest getCapitalRequest);

    CapitalInfoResponse getCapitalWithInfo(GetCapitalRequest getCapitalRequest);
}
