package ru.food.usecase.user.command.create;

import ru.food.usecase.cqrs.command.Command;
import ru.food.usecase.cqrs.command.CommandDefaultResponse;

public record CreateUserCommand(
        String login,
        String password)
        implements Command<CommandDefaultResponse> {}
