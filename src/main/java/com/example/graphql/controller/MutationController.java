package com.example.graphql.controller;

import com.example.graphql.domain.Customer;
import com.example.graphql.domain.CustomerInput;
import com.example.graphql.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class MutationController {

    @Autowired
    private CustomerService customerService;

    //TODO how to implement a method which parameter is Customer
//    @SchemaMapping(typeName = "Mutation", field = "addCustomer")
    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public Mono<Customer> addCustomer(@Argument CustomerInput customer){
        log.info("customer : {}", customer);
        return customerService.addCustomer(customer.getName());
    }

}
