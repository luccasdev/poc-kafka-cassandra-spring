package dev.luccas.ordermanager.repository;

import dev.luccas.ordermanager.model.Order;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface OrderRepository extends CassandraRepository<Order, UUID> {

}
