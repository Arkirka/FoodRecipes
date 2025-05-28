package ru.food.gateway.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;
import ru.food.gateway.domain.model.UserModel;
import ru.food.gateway.persistence.entity.identity.LongId;

@Setter
@Getter
@Table("\"user\"")
public class User extends UserModel implements LongId {
    private Long id;

    public User(String login, String password) {
        super(login, password);
    }

    public User(String login) {
        super(login);
    }

    public User() {
        super(null);
    }
}
