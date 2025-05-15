package ru.food.application.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.food.usecase.configuration.UseCaseConfiguration;

@Configuration
@Import(UseCaseConfiguration.class)
public class ApplicationConfig {
}
