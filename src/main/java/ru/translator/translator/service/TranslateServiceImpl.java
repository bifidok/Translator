package ru.translator.translator.service;

import org.springframework.stereotype.Service;
import ru.translator.translator.model.TranslationResponse;
import ru.translator.translator.requester.TranslationRequester;

@Service
public class TranslateServiceImpl implements TranslateService {
    private TranslationRequester requester;

    public TranslateServiceImpl(TranslationRequester requester) {
        this.requester = requester;
    }

    public TranslationResponse getTranslationResponse(String text, String targetLang){
        return requester.getData(text,targetLang);
    }
}
