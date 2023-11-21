package com.example.graphql.controller;

import com.example.graphql.domain.Greeting;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
public class GreetingController {

    @QueryMapping
    Greeting greeting(){
        return new Greeting("greetings : " + Instant.now().toString());
    }
}
