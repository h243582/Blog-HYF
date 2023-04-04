//package com.heyufei.common.config;
//
//import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
//import org.springframework.core.env.ConfigurableEnvironment;
//import org.springframework.core.env.PropertySource;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//
///**
// * 读取config表的配置信息
// * @author HeYuFei
// * @since 2023-04-03  11:28
// */
//@Component
//public class ConfigLoader {
//
//    @Resource
//    private ConfigurableEnvironment environment;
//    @Resource
//    private ConfigServicePropertySourceLocator locator;
//
////    /**
////     * 从数据库中读取配置信息，并将其转换为Properties对象
////     */
////    public Properties load() {
////        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT `key`, `value` FROM `config`");
////        Properties properties = new Properties();
////        for (Map<String, Object> map : list) {
////            properties.put(map.get("key"), map.get("value"));
////        }
////        return properties;
////    }
////
////    /**
////     * 在应用程序启动时，将从数据库中读取的配置信息注册到Spring Boot环境中
////     */
////    @EventListener(ApplicationReadyEvent.class)
////    public void registerConfig() {
////        Properties properties = load();
////        ConfigurableEnvironment environment = SpringApplication
////                .run(ConfigLoader.class)
////                .getEnvironment();
////        MutablePropertySources propertySources = environment.getPropertySources();
////        propertySources.addFirst(new PropertiesPropertySource("dbConfig", properties));
////    }
//
//    @PostConstruct
//    public void loadConfig() {
//        String[] profiles = environment.getActiveProfiles();
//        String applicationName = environment.getProperty("spring.application.name");
//        if (applicationName == null) {
//            applicationName = "application";
//        }
//        for (String profile : profiles) {
//            String label = environment.getProperty("spring.cloud.config.label");
//            String name = String.format("%s-%s", applicationName, profile);
//            PropertySource<?> propertySource = locator.locate(environment);
//            environment.getPropertySources().addFirst(propertySource);
//        }
//    }
//}
