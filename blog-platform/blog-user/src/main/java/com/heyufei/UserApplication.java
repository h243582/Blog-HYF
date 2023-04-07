package com.heyufei;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
//@ComponentScan(basePackages = {"com.heyufei.user.*","com.heyufei.common.*",})
@EnableJpaRepositories(basePackages = {"com.heyufei.user.*"})
@EntityScan(basePackages = {"com.heyufei.user.*"})
@EnableFeignClients(basePackages = {"com.heyufei.user.*"})
@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
