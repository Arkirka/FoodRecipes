package ru.food.recipe.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserModel {
    private final String login;
    private final String password;

    public UserModel(String login) {
        this.login = login;
        this.password = null;
    }
}
