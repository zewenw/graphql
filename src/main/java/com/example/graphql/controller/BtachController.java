package com.example.graphql.controller;

import com.example.graphql.domain.Customer;
import com.example.graphql.domain.Profile;
import com.example.graphql.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class BtachController {

    @Autowired
    private CustomerService customerService;

    @QueryMapping
    public Collection<Customer> customers(){
        return customerService.getCustomers();
    }

    @BatchMapping(typeName = "Customer", field = "profile")
    Map<Customer, Profile> batchProfileFor(List<Customer> customers){
        log.info("batch profile : {}", customers);
        return customers.stream()
                .collect(Collectors.toMap(
                        customer -> customer,
                        customer -> customerService.getProfileFor(customer)
                ));
    }
}
