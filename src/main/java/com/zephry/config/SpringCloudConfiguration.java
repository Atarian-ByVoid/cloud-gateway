package com.zephry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class SpringCloudConfiguration {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("syntetagmenes", r -> r.path("/heatmap/**").uri("lb://hermes-navigator"))
                .route("atlas", r -> r.path("/map-population/**").uri("lb://hermes-navigator"))
                .route("copernicus", r -> r.path("/temperature-map/**").uri("lb://hermes-navigator"))
                .build();
    }
}