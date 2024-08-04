package com.zephry.cloud_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class SpringCloudConfiguration {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("invoiceModule", r -> r.path("/invoice/**")
                        .uri("lb://invoice-service")
                )

                .route("customerModule", r -> r.path("/customer/**")
                        .uri("lb://customer-service")
                )
                .build();
    }
}