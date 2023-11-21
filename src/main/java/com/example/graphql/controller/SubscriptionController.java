package com.example.graphql.controller;

import com.example.graphql.domain.Customer;
import com.example.graphql.domain.Greeting;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Signal;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.Flow;
import java.util.function.Supplier;
import java.util.stream.Stream;

//@Controller
public class SubscriptionController {

//    @SubscriptionMapping
    Flux<Greeting> greetings() {
        return Flux.fromStream(Stream.generate(
                () -> new Greeting("hello world : wzw" + Instant.now())
        ))
                .delayElements(Duration.ofSeconds(1))
                .take(10);
    }


}
