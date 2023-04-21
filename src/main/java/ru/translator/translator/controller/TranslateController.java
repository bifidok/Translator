package ru.translator.translator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.translator.translator.model.TranslationResponse;
import ru.translator.translator.service.TranslateService;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/translate")
public class TranslateController {
    private final TranslateService service;

    public TranslateController(TranslateService service) {
        this.service = service;
    }

    @GetMapping()
    public TranslationResponse translate(@RequestParam(name = "target_lang") String targetLang,
                                               @RequestParam(name = "text") String text) {
        return service.getTranslationResponse(text,targetLang);
    }
}
