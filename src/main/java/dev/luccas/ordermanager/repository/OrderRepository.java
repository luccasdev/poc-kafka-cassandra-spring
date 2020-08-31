package dev.luccas.ordermanager.repository;

import dev.luccas.ordermanager.model.Order;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends CassandraRepository<Order, UUID> {

}
