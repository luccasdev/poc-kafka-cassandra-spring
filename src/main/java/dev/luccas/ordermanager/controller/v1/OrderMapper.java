package dev.luccas.ordermanager.controller.v1;


import dev.luccas.ordermanager.model.Order;
import lombok.experimental.UtilityClass;

import java.util.Objects;
import java.util.UUID;

@UtilityClass
public class OrderMapper {


    public OrderDto entityToDto(Order entity) {
        if (Objects.isNull(entity))
            return new OrderDto();
        return OrderDto.builder()
                .title(entity.getTitle())
                .description(entity.getDescription())
                .build();
    }

    public static Order dtoToEntity(OrderDto orderDto) {
        if (Objects.isNull(orderDto))
            return new Order();
        return Order.builder()
                .id(UUID.randomUUID())
                .description(orderDto.getDescription())
                .title(orderDto.getTitle())
                .build();
    }
}
