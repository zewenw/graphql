package com.example.graphql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class SecurityConfig {

//    @Bean
    SecurityWebFilterChain securityWebFilterChain() {
        return new SecurityWebFilterChain() {
            @Override
            public Mono<Boolean> matches(ServerWebExchange exchange) {
                return Mono.just(false);
            }

            @Override
            public Flux<WebFilter> getWebFilters() {
                return Flux.empty();
            }
        };
    }

    @Bean
    MapReactiveUserDetailsService authentication() {
        var users = Map.of("admin", "ADMIN,VIERER".split(","),
                "user", new String[]{"VIERER"},
                "none", new String[]{})
                .entrySet().stream()
                .map(en -> User.withDefaultPasswordEncoder()
                        .username(en.getKey())
                        .password("pw")
                        .roles(en.getValue())
                        .build())
                .collect(Collectors.toList());
        return new MapReactiveUserDetailsService(users);
    }

    @Bean
    SecurityWebFilterChain authorization(ServerHttpSecurity http) {
        return http
                .csrf(x -> x.disable())
//                .authorizeExchange(ae -> ae.anyExchange().authenticated())
                .authorizeExchange(ae -> ae.anyExchange().permitAll())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
