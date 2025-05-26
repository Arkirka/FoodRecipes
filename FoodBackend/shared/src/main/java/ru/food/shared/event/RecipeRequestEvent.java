package ru.food.shared.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.food.shared.model.RecipeRequest;

@Getter
public class RecipeRequestEvent extends ApplicationEvent {
    private final String correlationId;
    private final RecipeRequest payload;

    public RecipeRequestEvent(Object source, String correlationId, RecipeRequest payload) {
        super(source);
        this.correlationId = correlationId;
        this.payload = payload;
    }
}
