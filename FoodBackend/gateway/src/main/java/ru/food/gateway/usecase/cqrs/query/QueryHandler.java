package ru.food.gateway.usecase.cqrs.query;

import ru.food.gateway.usecase.cqrs.TaskHandler;

public interface QueryHandler<TQuery extends Query<Response>, Response> extends TaskHandler<TQuery, Response> {
}
