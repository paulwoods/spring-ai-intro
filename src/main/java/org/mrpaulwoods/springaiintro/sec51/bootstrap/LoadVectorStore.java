package org.mrpaulwoods.springaiintro.sec51.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mrpaulwoods.springaiintro.sec51.config.VectorStoreProperties;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class LoadVectorStore implements CommandLineRunner {

    private final VectorStore vectorStore;
    private final VectorStoreProperties vectorStoreProperties;

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading vector store");

        if (vectorStore.similaritySearch("Sportsman").isEmpty()) {
            log.info("Loading documents into vector store");

            vectorStoreProperties.getDocumentsToLoad().forEach(document -> {
                log.info("Loading document: {}", document.getFilename());

                TikaDocumentReader documentReader = new TikaDocumentReader(document);
                List<Document> documents = documentReader.read();

                TextSplitter textSplitter = new TokenTextSplitter();
                List<Document> splitDocuments = textSplitter.apply(documents);
                vectorStore.add(splitDocuments);
            });
        }

        log.info("Vector store loaded");
    }

}
