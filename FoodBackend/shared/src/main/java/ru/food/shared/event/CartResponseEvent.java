package ru.food.shared.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.food.shared.model.CartResponse;

@Getter
public class CartResponseEvent extends ApplicationEvent {
    private final String correlationId;
    private final CartResponse cart;

    public CartResponseEvent(Object source, String correlationId, CartResponse cart) {
        super(source);
        this.correlationId = correlationId;
        this.cart = cart;
    }
}
