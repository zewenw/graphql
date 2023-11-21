package com.example.graphql.client;

import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.graphql.client.RSocketGraphQlClient;
import org.springframework.stereotype.Component;

//@Configuration
public class GraphQLClientConfig {

    @Bean
    public HttpGraphQlClient httpGraphQlClient(){
        return HttpGraphQlClient.builder().url("http://127.0.0.1:8080/graphql").build();
    }

    @Bean
    public RSocketGraphQlClient rSocketGraphQlClient(RSocketGraphQlClient.Builder builder){
        return builder.tcp("127.0.0.1", 9191)
                .route("graphql")
                .build();
    }
}
