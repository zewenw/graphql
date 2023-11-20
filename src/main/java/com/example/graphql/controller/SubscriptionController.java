package com.example.graphql.controller;

import com.example.graphql.domain.Customer;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import java.time.Instant;
import java.util.UUID;

@Controller
public class SubscriptionController {

    @SubscriptionMapping
    Customer greetings(){
        return new Customer(UUID.randomUUID().toString(),  Instant.now().toString());
    }
}
