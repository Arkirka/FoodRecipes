package ru.food.shared.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.food.shared.model.ProductWithPrice;

import java.util.List;

@Getter
public class ExternalPriceEvent extends ApplicationEvent {
    private final String correlationId;
    private final List<ProductWithPrice> productList;

    public ExternalPriceEvent(Object source, String correlationId, List<ProductWithPrice> productList) {
        super(source);
        this.correlationId = correlationId;
        this.productList = productList;
    }
}
