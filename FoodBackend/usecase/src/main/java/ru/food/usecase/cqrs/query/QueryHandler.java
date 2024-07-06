package ru.food.usecase.cqrs.query;

import ru.food.usecase.cqrs.TaskHandler;

public interface QueryHandler<TQuery extends Query<Response>, Response> extends TaskHandler<TQuery, Response> {
}
