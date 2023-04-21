package ru.translator.translator.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "translator")
public class TranslationConfig {
    String url;
    String token;
    String folderId;
}
