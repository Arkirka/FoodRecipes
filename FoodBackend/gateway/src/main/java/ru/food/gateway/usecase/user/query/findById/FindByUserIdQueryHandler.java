package ru.food.gateway.usecase.user.query.findById;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.food.gateway.domain.repository.UserService;
import ru.food.gateway.usecase.cqrs.query.QueryHandler;

@Service
@RequiredArgsConstructor
public class FindByUserIdQueryHandler implements QueryHandler<FindByUserIdQuery, FindByUserIdQueryResponse> {
    private final UserService userService;

    @Override
    public Mono<FindByUserIdQueryResponse> handle(FindByUserIdQuery command) {
        return userService.findUserById(command.id())
                .map(x -> new FindByUserIdQueryResponse(x.getLogin(), x.getPassword()));
    }
}
