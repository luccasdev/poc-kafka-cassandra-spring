package dev.luccas.ordermanager.consumer;

import dev.luccas.ordermanager.model.Order;
import dev.luccas.ordermanager.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class OrderConsumer {

    private final OrderService orderService;

    public OrderConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final ConsumerRecord<String, Order> consumerRecord) {
        log.info("Creating order with queue-key: {}", consumerRecord.key());
        Order order = orderService.create(consumerRecord.value());
        log.info("Order {} - {} create with success.", order.getId(), order.getTitle());
    }

}
