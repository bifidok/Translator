package ru.translator.translator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Translation {
    private String text;
    private String detectedLanguageCode;
}
