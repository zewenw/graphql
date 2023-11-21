package com.example.graphql.client;

import com.example.graphql.domain.Customer;
import com.example.graphql.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.graphql.client.RSocketGraphQlClient;
import org.springframework.stereotype.Component;

@Component
public class ClientRunner implements ApplicationRunner {

    @Autowired
    private HttpGraphQlClient httpGraphQlClient;

    @Autowired
    private RSocketGraphQlClient rSocketGraphQlClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        var httpRequestDocument = """

                query {
                 customerById(id:1){
                  id, name
                 }
                }

                """;

        httpGraphQlClient.document(httpRequestDocument).retrieve("customerById").toEntity(Customer.class)
                .subscribe(System.out::println);


        var rsocketRequestDocument = """
                					
                subscription {
                 greetings { greeting } 
                }
                					
                """;
        rSocketGraphQlClient.document(rsocketRequestDocument)
                .retrieveSubscription("greetings")
                .toEntity(Greeting.class)
                .subscribe(System.out::println);

    }
}
