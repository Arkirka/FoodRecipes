package ru.food.usecase.user.command.create;

import reactor.core.publisher.Flux;
import ru.food.usecase.cqrs.command.CommandDefaultResponse;
import ru.food.usecase.cqrs.command.CommandHandler;
/**
 * Handles the command to create a new user.
 */
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand, CommandDefaultResponse> {
    @Override
    public Flux<CommandDefaultResponse> handle(CreateUserCommand command) {
        return Flux.just(new CommandDefaultResponse());
    }
}
