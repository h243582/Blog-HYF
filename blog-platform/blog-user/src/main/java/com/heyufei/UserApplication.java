package com.heyufei;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@ComponentScan(basePackages = {"com.heyufei.user.*"})
@EnableJpaRepositories(basePackages = {"com.heyufei.user.*"})
@EntityScan(basePackages = {"com.heyufei.user.*"})
@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

//	/**
//	 * 在应用程序启动时，将从数据库中读取的配置信息注册到Spring Boot环境中
//	 */
//	@EventListener(ApplicationReadyEvent.class)
//	public void registerConfig() {
//		Properties properties = configLoader.load();
//		ConfigurableEnvironment environment = SpringApplication
//				.run(UserApplication.class)
//				.getEnvironment();
//		MutablePropertySources propertySources = environment.getPropertySources();
//		propertySources.addFirst(new PropertiesPropertySource("dbConfig", properties));
//	}

}
