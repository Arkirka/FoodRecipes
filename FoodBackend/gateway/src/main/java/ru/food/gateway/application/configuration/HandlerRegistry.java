package ru.food.gateway.application.configuration;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.context.ApplicationContext;
import ru.food.gateway.usecase.cqrs.Task;
import ru.food.gateway.usecase.cqrs.TaskHandler;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Getter
@SuppressWarnings("rawtypes")
public class HandlerRegistry {
    private final Map<Class<? extends Task>, TaskHandler> handlers = new HashMap<>();
    private final ApplicationContext applicationContext;

    public HandlerRegistry(String basePackage, ApplicationContext context) {
        this.applicationContext = context;
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackages(basePackage)
                .addScanners(Scanners.SubTypes.filterResultsBy(x -> true)));

        Set<Class<? extends TaskHandler>> handlerClasses = reflections.getSubTypesOf(TaskHandler.class).stream()
                .filter(type -> !type.isInterface() && !java.lang.reflect.Modifier.isAbstract(type.getModifiers()))
                .collect(Collectors.toSet());

        handlerClasses.forEach(this::registerHandler);
    }

    private void registerHandler(Class<? extends TaskHandler> handlerClass) {
        TaskHandler handler = applicationContext.getBean(handlerClass);
        ParameterizedType type = (ParameterizedType) handlerClass.getGenericInterfaces()[0];
        @SuppressWarnings("unchecked")
        Class<? extends Task> taskType = (Class<? extends Task>) type.getActualTypeArguments()[0];
        handlers.put(taskType, handler);
        log.info("Registered task handler: {}:{}", taskType, handler);
    }
}
