package dev.luccas.ordermanager.listener;

import dev.luccas.ordermanager.controller.v1.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final ConsumerRecord<String, OrderDto> consumerRecord) {
        log.info("Order Title: " + consumerRecord.value().getTitle());
        log.info("key: " + consumerRecord.key());
        log.info("Headers: " + consumerRecord.headers());
        log.info("Partition: " + consumerRecord.partition());
    }

}
