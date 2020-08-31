package dev.luccas.ordermanager.controller.v1;


import dev.luccas.ordermanager.controller.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping
@RestController("v1/order")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public OrderDto findById(@PathVariable("orderId") UUID orderId) {
        return OrderMapper.entityToDto(this.orderService.findById(orderId));
    }

}
