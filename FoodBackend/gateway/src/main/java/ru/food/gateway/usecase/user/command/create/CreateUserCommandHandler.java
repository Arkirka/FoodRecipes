package ru.food.gateway.usecase.user.command.create;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.food.gateway.domain.model.UserModel;
import ru.food.gateway.domain.repository.UserService;
import ru.food.gateway.usecase.cqrs.command.CommandDefaultResponse;
import ru.food.gateway.usecase.cqrs.command.CommandHandler;

import java.nio.file.attribute.UserPrincipalNotFoundException;

/**
 * Handles the command to create a new user.
 */
@Service
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand, CommandDefaultResponse> {
    private final UserService userService;

    public CreateUserCommandHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Mono<CommandDefaultResponse> handle(CreateUserCommand command) {
        return userService.create(new UserModel(command.login(), command.password()))
                .switchIfEmpty(Mono.error(new UserPrincipalNotFoundException(command.login())))
                .map(x -> new CommandDefaultResponse());
    }
}
