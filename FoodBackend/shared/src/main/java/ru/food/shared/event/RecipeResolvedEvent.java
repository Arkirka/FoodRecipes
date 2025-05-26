package ru.food.shared.event;

import org.springframework.context.ApplicationEvent;
import ru.food.shared.model.RecipePerProduct;

import java.util.List;

public class RecipeResolvedEvent extends ApplicationEvent {
    private final String correlationId;
    private final List<RecipePerProduct> recipe;

    public RecipeResolvedEvent(Object source, String correlationId, List<RecipePerProduct> recipe) {
        super(source);
        this.correlationId = correlationId;
        this.recipe = recipe;
    }
}
