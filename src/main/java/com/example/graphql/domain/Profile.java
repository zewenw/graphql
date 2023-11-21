package com.example.graphql.domain;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profile {

    String id;
    String customerId;
    String name;
}
