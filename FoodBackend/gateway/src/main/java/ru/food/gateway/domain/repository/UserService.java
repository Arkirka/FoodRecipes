package ru.food.gateway.domain.repository;

import reactor.core.publisher.Mono;
import ru.food.gateway.domain.model.UserModel;

public interface UserService {
    Mono<? extends UserModel> findByLogin(String login);

    Mono<UserModel> findUserById(Long id);

    Mono<? extends UserModel> create(UserModel userModel);
}
