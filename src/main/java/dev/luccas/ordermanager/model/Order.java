package dev.luccas.ordermanager.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table
public class Order {

    @PrimaryKey
    private UUID id = UUID.randomUUID();

    private String title;

    private String description;

}
