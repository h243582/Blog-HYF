package com.heyufei.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@ComponentScan(basePackages = {"com.heyufei.gateway.*"})
@EnableJpaRepositories(basePackages = {"com.heyufei.gateway.*"})
@EntityScan(basePackages = {"com.heyufei.gateway.*"})
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
