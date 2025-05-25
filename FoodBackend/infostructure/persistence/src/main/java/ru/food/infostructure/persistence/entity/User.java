package ru.food.infostructure.persistence.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.food.domain.model.UserModel;
import ru.food.infostructure.persistence.entity.identity.LongId;

@Setter
@Getter
public class User extends UserModel implements LongId {
    private Long id;

    public User(String login, String password) {
        super(login, password);
    }

    public User(String login) {
        super(login);
    }
}
