package ru.food.usecase.user.query.findById;

import ru.food.domain.User;
import ru.food.usecase.cqrs.query.Query;

public record FindUserByIdQuery(Long id) implements Query<User> {}
