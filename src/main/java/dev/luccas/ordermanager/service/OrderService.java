package dev.luccas.ordermanager.service;

import dev.luccas.ordermanager.controller.v1.OrderMapper;
import dev.luccas.ordermanager.model.Order;
import dev.luccas.ordermanager.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {

    private static final String ORDER_TOPIC = "order";

    private final KafkaTemplate<String, Order> kafkaTemplate;

    private final OrderRepository orderRepository;

    public OrderService(KafkaTemplate<String, Order> kafkaTemplate, OrderRepository orderRepository) {
        this.kafkaTemplate = kafkaTemplate;
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

    public void send(Order order) {
        kafkaTemplate.send(ORDER_TOPIC, UUID.randomUUID().toString(), order);
    }

    public void send(Order order, String key) {
        kafkaTemplate.send(ORDER_TOPIC, key, order);
    }
}
