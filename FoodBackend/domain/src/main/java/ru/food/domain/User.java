package ru.food.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class User {
    private static String login;
    private static String password;
}
