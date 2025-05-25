package ru.food.gateway.application.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.food.gateway.usecase.cqrs.Task;
import ru.food.gateway.usecase.cqrs.TaskHandler;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final Map<Class<? extends Task>, TaskHandler> taskHandlers;

    @SuppressWarnings("unchecked")
    public <Response> Mono<Response> send(Task<Response> task) {
        TaskHandler<Task<Response>, Response> handler = taskHandlers.get(task.getClass());
        if (handler == null) {
            throw new IllegalArgumentException("No handler found for task: " + task.getClass());
        }
        return handler.handle(task);
    }
}
