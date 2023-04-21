package ru.translator.translator.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TranslationConfig.class)
public class ApplicationConfig {
}
