package ru.food.infostructure.persistance.entity;

import lombok.Getter;
import lombok.Setter;
import ru.food.infostructure.persistance.entity.identity.LongId;

@Setter
@Getter
public class User extends ru.food.domain.User implements LongId {
    private Long id;
}
