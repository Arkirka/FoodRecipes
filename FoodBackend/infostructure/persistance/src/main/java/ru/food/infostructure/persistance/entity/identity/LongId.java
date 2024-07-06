package ru.food.infostructure.persistance.entity.identity;

import org.springframework.data.annotation.Id;

public interface LongId {
    @Id
    Long getId();
    @Id
    void setId(Long id);
}
