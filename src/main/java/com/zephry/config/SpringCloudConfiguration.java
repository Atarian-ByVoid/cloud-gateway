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

                // HERMES NAVIGADOR MS
                .route("syntetagmenes", r -> r.path("/heatmap/**").uri("lb://hermes-navigator"))
                .route("atlas", r -> r.path("/map-population/**").uri("lb://hermes-navigator"))
                .route("copernicus", r -> r.path("/temperature-map/**").uri("lb://hermes-navigator"))

                //DIMIOURGIA MS
                .route("swagger-ui", r -> r.path("/dimiourgia/swagger-ui/**").uri("lb://dimiourgia"))
				.route("swagger-resources", r -> r.path("/dimiourgia/swagger-resources/**").uri("lb://dimiourgia"))
				.route("v3", r -> r.path("/dimiourgia/v3/**").uri("lb://dimiourgia"))
                .route("user", r -> r.path("/user/**").uri("lb://dimiourgia"))
                .route("auth", r -> r.path("/auth/**").uri("lb://dimiourgia"))
                .build();
    }
}