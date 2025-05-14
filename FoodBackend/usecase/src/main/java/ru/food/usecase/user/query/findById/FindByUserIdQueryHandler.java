package ru.food.usecase.user.query.findById;

import reactor.core.publisher.Flux;
import ru.food.usecase.cqrs.query.QueryHandler;

public class FindByUserIdQueryHandler implements QueryHandler<FindByUserIdQuery, FindByUserIdQueryResponse> {

    @Override
    public Flux<FindByUserIdQueryResponse> handle(FindByUserIdQuery command) {
        return null;
    }
}
