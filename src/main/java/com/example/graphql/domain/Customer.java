package com.example.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Value
public class Customer {

    String id;
    String name;
}
