package com.example.graphql.service;

import com.example.graphql.domain.Customer;
import com.example.graphql.domain.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    public Profile getProfileFor(Customer customer){
        return new Profile("1", customer.getId());
    }

    public Collection<Customer> getCustomers(){
        return List.of(new Customer("1", "A"),
                new Customer("2", "B"));
    }

    public Customer getCustomerById(String id) {
        return new Customer(id, "C");
    }
}
