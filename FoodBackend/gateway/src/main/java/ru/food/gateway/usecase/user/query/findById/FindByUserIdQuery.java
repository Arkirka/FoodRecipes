package ru.food.gateway.usecase.user.query.findById;

import ru.food.gateway.usecase.cqrs.query.Query;

public record FindByUserIdQuery(Long id) implements Query<FindByUserIdQueryResponse> {}
