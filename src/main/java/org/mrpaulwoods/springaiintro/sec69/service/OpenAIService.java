package org.mrpaulwoods.springaiintro.sec69.service;

import org.mrpaulwoods.springaiintro.sec69.model.Question;
import org.springframework.web.multipart.MultipartFile;

public interface OpenAIService {

    byte[] getImage(Question question);

    String getDescription(MultipartFile file);
}
