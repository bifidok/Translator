package ru.translator.translator.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TranslationResponse {
    private List<Translation> translations;
}
