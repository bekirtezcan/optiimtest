package com.optiimtest.noteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableEurekaClient
public class NoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(NoteServiceApplication.class);
        app.setWebApplicationType(WebApplicationType.REACTIVE);
        SpringApplication.run(NoteServiceApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList()));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

@Configuration
class RestTemplateConfig {

    // Create a bean for restTemplate to call services
    @Bean
    @LoadBalanced        // Load balance between service instances running at different ports.
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}