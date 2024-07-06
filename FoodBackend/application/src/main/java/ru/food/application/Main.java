package ru.food.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.food")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}