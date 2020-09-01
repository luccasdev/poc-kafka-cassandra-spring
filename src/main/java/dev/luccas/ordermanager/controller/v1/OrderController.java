package dev.luccas.ordermanager.controller.v1;


import dev.luccas.ordermanager.service.OrderService;
import dev.luccas.ordermanager.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

