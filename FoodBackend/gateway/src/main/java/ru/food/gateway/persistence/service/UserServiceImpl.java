package ru.food.gateway.persistence.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.food.gateway.domain.model.UserModel;
import ru.food.gateway.domain.repository.UserService;
import ru.food.gateway.persistence.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepositoryReactive;

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
