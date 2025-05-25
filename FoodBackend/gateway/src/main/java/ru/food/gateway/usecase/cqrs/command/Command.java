package ru.food.gateway.usecase.cqrs.command;

import ru.food.gateway.usecase.cqrs.Task;

public interface Command<Response> extends Task<Response> {}