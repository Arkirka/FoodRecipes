package ru.food.cart.usecase.cqrs.command;


import ru.food.cart.usecase.cqrs.TaskHandler;

public interface CommandHandler<TCommand extends Command<Response>, Response> extends TaskHandler<TCommand, Response> {
}
