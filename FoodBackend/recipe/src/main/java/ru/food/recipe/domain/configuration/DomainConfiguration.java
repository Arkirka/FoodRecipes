package ru.food.recipe.domain.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.food.recipe.domain.repository.UserService;

@Configuration
public class DomainConfiguration {

    @Bean
    public UserService userService(ApplicationContext applicationContext) {
        return (UserService) applicationContext.getBean("UserServiceImpl");
    }
}
