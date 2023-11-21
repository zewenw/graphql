package com.example.graphql.service;

import com.example.graphql.domain.Customer;
import com.example.graphql.domain.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerService {

    private Map<String, Customer> db = new ConcurrentHashMap<>();
    private final AtomicInteger id = new AtomicInteger();

    {
        log.info("customer service initial data");
        db.put("1", new Customer(String.valueOf(id.incrementAndGet()), "A"));
        db.put("2", new Customer(String.valueOf(id.incrementAndGet()), "B"));
    }


    public Profile getProfileFor(Customer customer){
        return new Profile("1", customer.getId());
    }

    public Collection<Customer> getCustomers(){
        return new ArrayList<>(db.values());
    }

    public Mono<Customer> getCustomerById(String id) {
        Customer customer = db.values().stream()
                .filter(value -> value.getId().equals(id))
                .findAny().orElse(null);
        return Mono.just(customer);
    }

    public Mono<Customer> addCustomer(String name) {
        Customer customer = Customer.builder()
                .id(String.valueOf(id.incrementAndGet()))
                .name(name)
                .build();
        db.put(customer.getId(), customer);
        return Mono.just(customer);
    }
}
