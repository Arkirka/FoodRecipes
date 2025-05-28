package ru.food.gateway.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.food.shared.event.CartResponseEvent;
import ru.food.shared.event.RecipeRequestEvent;
import ru.food.shared.model.CartResponse;
import ru.food.shared.model.RecipeRequest;

import java.util.UUID;

@RestController("/recipe")
@RequiredArgsConstructor
public class RecipeController {
    private final ApplicationEventPublisher publisher;
    // private final ResponseStorage responseStorage;

    @GetMapping
    public Mono<CartResponse> generateCart(@RequestBody RecipeRequest request) {
        String correlationId = UUID.randomUUID().toString();
        // TODO: нужно подумать над хранилищем для ивентов и его уровнем в архитектуре модуля, пока пусть будет заглушка ResponseStorage в комментах
        Mono<CartResponse> result = Mono.empty();
        // responseStorage.put(correlationId, result);
        publisher.publishEvent(new RecipeRequestEvent(this, correlationId, request));

        return result;
    }

    @EventListener
    public void onCartReady(CartResponseEvent event) {
        // responseStorage.complete(event.getCorrelationId(), event.getCart());
    }
}
