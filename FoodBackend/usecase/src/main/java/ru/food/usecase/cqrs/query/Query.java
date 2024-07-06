package ru.food.usecase.cqrs.query;

import ru.food.usecase.cqrs.Task;

public interface Query<Response> extends Task<Response> {}
