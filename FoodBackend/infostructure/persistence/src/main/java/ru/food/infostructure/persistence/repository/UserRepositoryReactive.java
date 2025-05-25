package ru.food.infostructure.persistence.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.food.domain.model.UserModel;
import ru.food.infostructure.persistence.entity.User;

@Repository
public interface UserRepositoryReactive extends ReactiveCrudRepository<User, Long> {
    @Query("SELECT * FROM USER WHERE LOGIN = :login")
    Mono<? extends UserModel> findByLogin(String login);

    default Mono<UserModel> findUserById(Long id){
        return findById(id).map(x -> new UserModel(x.getLogin()));
    }

    default Mono<? extends UserModel> create(UserModel userModel){
        return save((User) userModel);
    }
}
