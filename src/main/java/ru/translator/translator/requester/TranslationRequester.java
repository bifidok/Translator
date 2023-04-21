package ru.translator.translator.requester;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import ru.translator.translator.config.TranslationConfig;
import ru.translator.translator.model.TranslationResponse;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class TranslationRequester {
    private final TranslationConfig translationConfig;

    public TranslationRequester(TranslationConfig translationConfig) {
        this.translationConfig = translationConfig;
    }

    public TranslationResponse getData(String text, String targetLang) {
        WebClient client = WebClient.builder()
                .baseUrl(translationConfig.getUrl()).build();

        return client.post()
                .headers(h -> {
                    h.setBearerAuth(translationConfig.getToken());
                })
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(generateBody(text, targetLang)))
                .retrieve()
                .bodyToMono(TranslationResponse.class)
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .block();
    }
    private Map<String,String> generateBody(String text, String targetLang){
        Map<String,String> map = new HashMap<>();
        map.put("folderId", translationConfig.getFolderId());
        map.put("texts", text);
        map.put("targetLanguageCode", targetLang);
        return map;
    }
}
