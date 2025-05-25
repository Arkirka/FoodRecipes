package ru.food.cart.usecase.cqrs.command;

import ru.food.cart.usecase.cqrs.Task;

public interface Command<Response> extends Task<Response> {}