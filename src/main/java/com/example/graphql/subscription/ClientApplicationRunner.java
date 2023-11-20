package com.example.graphql.subscription;

import com.example.graphql.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.graphql.client.RSocketGraphQlClient;
import org.springframework.stereotype.Component;

//@Component
public class ClientApplicationRunner implements ApplicationRunner {

    @Autowired
    private RSocketGraphQlClient rsocket;

    @Autowired
    private HttpGraphQlClient httpGraphQlClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String rsocketRequestDocument = "subscription {\n" +
                "\t\t\t\t\t greetings { greeting } \n" +
                "\t\t\t\t\t}";
        rsocket.document(rsocketRequestDocument)
                .retrieveSubscription("greetings")
                .toEntity(Greeting.class)
                .subscribe(System.out::println);
    }
}
