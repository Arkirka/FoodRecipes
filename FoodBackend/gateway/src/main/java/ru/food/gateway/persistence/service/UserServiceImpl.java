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
    private final UserRepository userRepository;

    @Override
    public Mono<? extends UserModel> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Mono<? extends UserModel> findUserById(Long id) {
        return userRepository.findUserById(id).map(x -> new UserModel(x.getLogin()));
    }

    @Override
    public Mono<? extends UserModel> create(UserModel userModel) {
        return userRepository.create(userModel);
    }
}
