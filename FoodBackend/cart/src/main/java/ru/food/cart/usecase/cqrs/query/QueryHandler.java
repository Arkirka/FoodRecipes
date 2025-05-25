package ru.food.cart.usecase.cqrs.query;

import ru.food.cart.usecase.cqrs.TaskHandler;

public interface QueryHandler<TQuery extends Query<Response>, Response> extends TaskHandler<TQuery, Response> {
}
