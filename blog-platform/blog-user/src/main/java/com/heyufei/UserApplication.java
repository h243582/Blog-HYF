package com.heyufei;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.Resource;

@Slf4j
@ComponentScan(basePackages = {"com.heyufei.user.*"})
@EnableJpaRepositories(basePackages = {"com.heyufei.user.*"})
@EntityScan(basePackages = {"com.heyufei.user.*"})
@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Resource
    private ConfigurableEnvironment environment;
    @Resource
    private ConfigServicePropertySourceLocator locator;
    @Bean
    public void loadConfig() {
        String[] profiles = environment.getActiveProfiles();
        String applicationName = environment.getProperty("spring.application.name");
        if (applicationName == null) {
            applicationName = "application";
        }
        for (String profile : profiles) {
            String label = environment.getProperty("spring.cloud.config.label");
            String name = String.format("%s-%s", applicationName, profile);
            PropertySource<?> propertySource = locator.locate(environment);
            environment.getPropertySources().addFirst(propertySource);
        }
    }
}
