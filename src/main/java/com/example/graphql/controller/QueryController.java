package com.example.graphql.controller;

import com.example.graphql.domain.Customer;
import com.example.graphql.domain.Profile;
import com.example.graphql.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Slf4j
@Controller
public class QueryController {

    @Autowired
    private CustomerService customerService;

//    @SchemaMapping(typeName = "Query", field = "hello")
    @QueryMapping
    public String hello(){
        return "hello world!";
    }

    @SchemaMapping(typeName = "Query", field = "helloWithName")
    public String helloWithName(@Argument String name){
        return "hello " + name + "!";
    }

    @QueryMapping
    public Customer customerByName(@Argument String name){
        return new Customer("5", name);
    }

    /**
     * either the method name equals to the field name
     * or the value of field property within SchemaMapping equals to the field
     */
//    @SchemaMapping(typeName = "Customer", field = "profile")
//    @SchemaMapping(typeName = "Customer", field = "profile")
    public Profile getProfileFor(Customer customer){
        log.info("get profile for customer:{}", customer);
        return customerService.getProfileFor(customer);
    }
}
