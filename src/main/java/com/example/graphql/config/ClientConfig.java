package com.example.graphql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.graphql.client.RSocketGraphQlClient;

//@Configuration
public class ClientConfig {

//    @Bean
    RSocketGraphQlClient rSocketGraphQlClient(RSocketGraphQlClient.Builder<?> builder){
        return builder.tcp("127.0.0.1", 9191)
                .route("graphql")
                .build();
    }

//    @Bean
    HttpGraphQlClient httpGraphQlClient(){
        return HttpGraphQlClient.builder()
                .url("http://127.0.0.1:8080/graphql")
                .build();
    }
}

