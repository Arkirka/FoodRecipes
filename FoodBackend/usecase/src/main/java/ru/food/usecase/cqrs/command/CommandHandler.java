package ru.food.usecase.cqrs.command;


import ru.food.usecase.cqrs.TaskHandler;

public interface CommandHandler<TCommand extends Command<Response>, Response> extends TaskHandler<TCommand, Response> {
}
