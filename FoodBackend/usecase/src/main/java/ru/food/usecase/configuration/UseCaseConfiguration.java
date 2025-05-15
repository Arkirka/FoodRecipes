package ru.food.usecase.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.food.domain.configuration.DomainConfig;

@Configuration
@Import(DomainConfig.class)
public class UseCaseConfiguration {
}
