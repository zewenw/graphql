package com.example.graphql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SecurityController {


    @GetMapping("/hello")
    public Mono<String> helloWorld(){
        return Mono.just("hello world");
    }
}
