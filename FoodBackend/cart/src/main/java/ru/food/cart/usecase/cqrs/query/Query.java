package ru.food.cart.usecase.cqrs.query;

import ru.food.cart.usecase.cqrs.Task;

public interface Query<Response> extends Task<Response> {}
