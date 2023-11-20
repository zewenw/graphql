package com.example.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor
public class Profile {

    String id;
    String customerId;
}
