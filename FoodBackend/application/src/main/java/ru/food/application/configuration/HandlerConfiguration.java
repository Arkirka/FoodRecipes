package ru.food.application.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.food.usecase.cqrs.Task;
import ru.food.usecase.cqrs.TaskHandler;

import java.util.Map;

@Setter
@Getter
@Configuration
public class HandlerConfiguration {
    @Value("${package.handlers}")
    private String handlersPackage;

    @Bean
    public Map<Class<? extends Task>, TaskHandler> taskHandlers() {
        var temp = new HandlerRegistry(handlersPackage).getHandlers();
        return temp;
    }
}
