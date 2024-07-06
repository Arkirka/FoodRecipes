package ru.food.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.food.usecase.Temp;

@RestController
public class TestController {

    private final Temp temp;

    public TestController(Temp temp) {
        this.temp = temp;
    }

    @GetMapping("/test")
    public Mono<String> doTest(){
        return Mono.just(temp.doSome());
    }
}
