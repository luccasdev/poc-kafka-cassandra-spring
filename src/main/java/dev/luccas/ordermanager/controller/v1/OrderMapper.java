package dev.luccas.ordermanager.controller.v1;


import dev.luccas.ordermanager.model.Order;
import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class OrderMapper {


    public OrderDto entityToDto(Order entity) {
        if (Objects.isNull(entity))
            return new OrderDto();
        return OrderDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .build();
    }
}
