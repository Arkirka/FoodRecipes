package ru.food.usecase.user.query.findById;

import reactor.core.publisher.Flux;
import ru.food.domain.User;
import ru.food.usecase.cqrs.query.QueryHandler;

public class FindUserByIdQueryHandler implements QueryHandler<FindUserByIdQuery, User> {

    @Override
    public Flux<User> handle(FindUserByIdQuery command) {
        return null;
    }
}
