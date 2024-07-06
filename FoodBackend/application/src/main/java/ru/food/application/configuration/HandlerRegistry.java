package ru.food.application.configuration;

import lombok.Getter;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import ru.food.usecase.cqrs.Task;
import ru.food.usecase.cqrs.TaskHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@SuppressWarnings("rawtypes")
public class HandlerRegistry {
    private final Map<Class<? extends Task>, TaskHandler> handlers = new HashMap<>();

    public HandlerRegistry(String basePackage) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackages(basePackage)
                .addScanners(Scanners.SubTypes.filterResultsBy(x -> true)));

        Set<Class<? extends TaskHandler>> handlerClasses = reflections.getSubTypesOf(TaskHandler.class).stream()
                .filter(type -> !type.isInterface() && !java.lang.reflect.Modifier.isAbstract(type.getModifiers()))
                .collect(Collectors.toSet());

        handlerClasses.forEach(this::registerHandler);
    }

    private void registerHandler(Class<? extends TaskHandler> handlerClass) {
        try {
            TaskHandler handler = handlerClass.getDeclaredConstructor().newInstance();
            ParameterizedType type = (ParameterizedType) handlerClass.getGenericInterfaces()[0];
            @SuppressWarnings("unchecked")
            Class<? extends Task> taskType = (Class<? extends Task>) type.getActualTypeArguments()[0];
            handlers.put(taskType, handler);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(
                    "Не удалось найти конструктор для класса %s. Ошибка вот такая: [%s]"
                        .formatted(handlerClass, e.getStackTrace())
            );
        }
    }
}
