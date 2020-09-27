package dev.luccas.ordermanager.service;

import dev.luccas.ordermanager.model.Order;
import dev.luccas.ordermanager.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findById(UUID orderId) {
        return this.orderRepository.findById(orderId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }


    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    public Order create(Order order) {
        return this.orderRepository.save(order);
    }
}
