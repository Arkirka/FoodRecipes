package ru.food.gateway.usecase.cqrs.query;

import ru.food.gateway.usecase.cqrs.Task;

public interface Query<Response> extends Task<Response> {}
