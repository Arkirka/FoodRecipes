package ru.food.gateway.usecase.cqrs.command;


import ru.food.gateway.usecase.cqrs.TaskHandler;

public interface CommandHandler<TCommand extends Command<Response>, Response> extends TaskHandler<TCommand, Response> {
}
