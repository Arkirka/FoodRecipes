package ru.food.cart.usecase.user.query.findById;

import ru.food.cart.usecase.cqrs.query.Query;

public record FindByUserIdQuery(Long id) implements Query<FindByUserIdQueryResponse> {}
