package com.example.graphql.service;

import com.example.graphql.domain.Customer;
import com.example.graphql.domain.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerService {

    private Map<String, Customer> db = new ConcurrentHashMap<>();

    {
        log.info("customer service initial data");
        db.put("1", new Customer("1", "A"));
        db.put("2", new Customer("2", "B"));
    }


    public Profile getProfileFor(Customer customer){
        return new Profile("1", customer.getId());
    }

    public Collection<Customer> getCustomers(){
        return new ArrayList<>(db.values());
    }

    public Customer getCustomerById(String id) {
        return db.values().stream()
                .filter(value -> value.getId().equals(id))
                .findAny().orElse(null);
    }

    public Customer addCustomer(String name) {
        Customer customer = Customer.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .build();
        db.put(customer.getId(), customer);
        return customer;
    }
}
