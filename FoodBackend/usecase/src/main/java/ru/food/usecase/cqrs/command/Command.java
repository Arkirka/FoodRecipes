package ru.food.usecase.cqrs.command;

import ru.food.usecase.cqrs.Task;

public interface Command<Response> extends Task<Response> {}