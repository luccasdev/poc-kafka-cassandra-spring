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


    private static final String ORDER_TOPIC = "order";

    private final OrderService orderService;

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderController(OrderService orderService, KafkaTemplate<String, Order> kafkaTemplate) {
        this.orderService = orderService;
        this.kafkaTemplate = kafkaTemplate;
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
        kafkaTemplate.send(ORDER_TOPIC, UUID.randomUUID().toString(), OrderMapper.dtoToEntity(orderDto));
        return orderDto;
    }
}

