package ru.food.gateway.usecase.user.command.create;

import ru.food.gateway.usecase.cqrs.command.Command;
import ru.food.gateway.usecase.cqrs.command.CommandDefaultResponse;

public record CreateUserCommand(
        String login,
        String password)
        implements Command<CommandDefaultResponse> {}
