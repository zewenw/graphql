package com.example.graphql.domain;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    String id;
    String name;

}
