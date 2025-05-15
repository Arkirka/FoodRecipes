package ru.food.infostructure.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import ru.food.domain.model.UserModel;
import ru.food.infostructure.persistence.entity.identity.LongId;

@Setter
@Getter
public class User extends UserModel implements LongId {
    private Long id;
}
