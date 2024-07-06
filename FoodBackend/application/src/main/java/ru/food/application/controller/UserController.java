package ru.food.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.food.application.sevice.TaskService;
import ru.food.usecase.user.command.create.CreateUserCommand;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final TaskService service;

    @PostMapping("")
    public Mono<String> create(@RequestBody CreateUserCommand command) {
        return service.send(command).single().map("Ты молодец! Вот держи свою %s"::formatted);
    }

    @GetMapping("/{id}")
    public Mono<String> doTest(@PathVariable Long id){

        return null;
    }
}
