package ru.food.domain.repository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.food.domain.model.UserModel;

@Repository
public interface UserRepository {
    Mono<? extends UserModel> findByLogin(String login);
}
