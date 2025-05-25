package ru.food.cart.usecase.user.command.create;

import ru.food.cart.usecase.cqrs.command.Command;
import ru.food.cart.usecase.cqrs.command.CommandDefaultResponse;

public record CreateUserCommand(
        String login,
        String password)
        implements Command<CommandDefaultResponse> {}
