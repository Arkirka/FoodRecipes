package ru.food.usecase.user.command.create;

import ru.food.usecase.cqrs.command.Command;

public record CreateUserCommand(
        String login,
        String password)
        implements Command<Long> {}
