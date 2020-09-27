package dev.luccas.ordermanager.controller.v1;


import dev.luccas.ordermanager.service.OrderService;
import dev.luccas.ordermanager.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order/v1")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public OrderDto findById(@PathVariable UUID orderId) {
        return OrderMapper.entityToDto(this.orderService.findById(orderId));
    }

    @GetMapping
    public List<OrderDto> findAll() {
        List<Order> orders = this.orderService.findAll();
        return orders.stream().map(OrderMapper::entityToDto).collect(Collectors.toList());
    }

    @PostMapping
    public OrderDto create(@RequestBody OrderDto orderDto) {
        this.orderService.send(OrderMapper.dtoToEntity(orderDto));
        return orderDto;
    }
}

