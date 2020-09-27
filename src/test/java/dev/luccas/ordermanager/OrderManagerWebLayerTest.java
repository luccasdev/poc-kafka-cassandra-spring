package dev.luccas.ordermanager;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.luccas.ordermanager.service.OrderService;
import dev.luccas.ordermanager.controller.v1.OrderController;
import dev.luccas.ordermanager.model.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
@ActiveProfiles("test")
public class OrderManagerWebLayerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    OrderService orderService;

    @MockBean
    KafkaTemplate<String, Order> kafkaTemplate;

    @Test
    public void get_findOrderById() throws Exception {
        UUID randomUUID = UUID.randomUUID();
        Order order = new Order();
        order.setDescription("The special food");
        order.setTitle("Delicious HotDog");
        order.setId(randomUUID);

        Mockito.when(orderService.findById(randomUUID)).thenReturn(order);

        mockMvc.perform(MockMvcRequestBuilders.get("/order/v1/" + randomUUID.toString()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(randomUUID.toString()));
    }

    @Test
    public void get_findAll() throws Exception {
        UUID randomUUID = UUID.randomUUID();

        Order order = new Order();
        order.setDescription("The special food");
        order.setTitle("Delicious HotDog");
        order.setId(randomUUID);

        Mockito.when(orderService.findAll()).thenReturn(Collections.singletonList(order));

        mockMvc.perform(MockMvcRequestBuilders.get("/order/v1/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(randomUUID.toString()));
    }
}
