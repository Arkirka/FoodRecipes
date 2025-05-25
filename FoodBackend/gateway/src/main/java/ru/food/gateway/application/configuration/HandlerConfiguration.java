package ru.food.gateway.application.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.food.gateway.usecase.cqrs.Task;
import ru.food.gateway.usecase.cqrs.TaskHandler;

import java.util.Map;

@Setter
@Getter
@Configuration
public class HandlerConfiguration {
    @Value("${package.usecase}")
    private String handlersPackage;

    @Bean
    public Map<Class<? extends Task>, TaskHandler> taskHandlers(ApplicationContext applicationContext) {
        var temp = new HandlerRegistry(handlersPackage, applicationContext).getHandlers();
        return temp;
    }
}
