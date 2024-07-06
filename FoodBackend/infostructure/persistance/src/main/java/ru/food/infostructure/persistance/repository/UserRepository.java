package ru.food.infostructure.persistance.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ru.food.infostructure.persistance.entity.User;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    @Query("SELECT * FROM USER WHERE LOGIN = :login")
    Mono<User> findByLogin(String login);
}
