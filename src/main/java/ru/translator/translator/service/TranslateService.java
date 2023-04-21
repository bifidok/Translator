package ru.translator.translator.service;

import ru.translator.translator.model.TranslationResponse;

import java.net.URISyntaxException;

public interface TranslateService {
    TranslationResponse getTranslationResponse(String text, String targetLang);
}
