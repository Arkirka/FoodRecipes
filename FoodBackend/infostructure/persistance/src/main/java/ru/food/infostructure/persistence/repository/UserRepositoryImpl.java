package ru.food.infostructure.persistence.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ru.food.domain.model.UserModel;
import ru.food.domain.repository.UserRepository;
import ru.food.infostructure.persistence.entity.User;

public interface UserRepositoryImpl extends UserRepository, ReactiveCrudRepository<User, Long> {
    @Query("SELECT * FROM USER WHERE LOGIN = :login")
    Mono<? extends UserModel> findByLogin(String login);
}
