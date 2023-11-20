package com.example.graphql.controller;

import com.example.graphql.domain.Customer;
import com.example.graphql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationController {

    @Autowired
    private CustomerService customerService;

    //TODO how to implement a method which parameter is Customer
//    @SchemaMapping(typeName = "Mutation", field = "addCustomer")
    @MutationMapping
    public Customer addCustomer(@Argument String name){
        return customerService.addCustomer(name);
    }

}
