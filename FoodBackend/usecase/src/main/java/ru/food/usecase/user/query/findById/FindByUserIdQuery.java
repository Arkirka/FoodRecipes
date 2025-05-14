package ru.food.usecase.user.query.findById;

import ru.food.usecase.cqrs.query.Query;

public record FindByUserIdQuery(Long id) implements Query<FindByUserIdQueryResponse> {}
