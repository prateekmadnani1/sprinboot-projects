package com.masters.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bank Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket {
    @Id
    @GeneratedValue
    private int id;
    private double price;
    private String description;
}
