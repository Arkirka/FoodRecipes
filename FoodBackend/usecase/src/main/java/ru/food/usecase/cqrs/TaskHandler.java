package ru.food.usecase.cqrs;

import reactor.core.publisher.Flux;

public interface TaskHandler <TTask extends Task<Response>, Response>{
    Flux<Response> handle(TTask command);
}
