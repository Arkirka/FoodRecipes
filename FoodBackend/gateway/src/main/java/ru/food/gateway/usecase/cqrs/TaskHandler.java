package ru.food.gateway.usecase.cqrs;

import reactor.core.publisher.Mono;

public interface TaskHandler <TTask extends Task<Response>, Response>{
    Mono<Response> handle(TTask command);
}
