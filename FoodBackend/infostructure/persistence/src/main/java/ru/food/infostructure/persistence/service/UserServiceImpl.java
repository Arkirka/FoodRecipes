package ru.food.infostructure.persistence.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.food.domain.model.UserModel;
import ru.food.domain.repository.UserService;
import ru.food.infostructure.persistence.repository.UserRepositoryReactive;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepositoryReactive userRepositoryReactive;

    @Override
    public Mono<? extends UserModel> findByLogin(String login) {
        return userRepositoryReactive.findByLogin(login);
    }

    @Override
    public Mono<UserModel> findUserById(Long id) {
        return userRepositoryReactive.findUserById(id);
    }

    @Override
    public Mono<? extends UserModel> create(UserModel userModel) {
        return userRepositoryReactive.create(userModel);
    }
}
