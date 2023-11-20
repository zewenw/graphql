package com.example.graphql.config;

import com.example.graphql.service.CustomerService;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

//@Configuration
public class wiringConfig {

//    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer(CustomerService customerService){
        return new RuntimeWiringConfigurer() {
            @Override
            public void configure(RuntimeWiring.Builder builder) {
                builder.type("Customer", wiring -> wiring.
                        dataFetcher("profile",
                                environment -> customerService.getProfileFor(
                                environment.getSource()
                        )));

                builder.type("Query", wiring -> wiring
                        .dataFetcher("customerById",
                                environment -> customerService.getCustomerById(
                                        environment.getArgument("id")
                                ))
                        .dataFetcher("customers",
                                environment -> customerService.getCustomers()));
            }
        };
    }
}


