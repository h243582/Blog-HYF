DROP TABLE IF EXISTS `config`;
create table if not exists `config`(
    `id` bigint(0) NOT NULL AUTO_INCREMENT,
    `key` varchar(255) NOT NULL comment '键',
    `value` varchar(255) NOT NULL comment '值',
    `comment` varchar(255) comment '说明',
    `application` varchar(255) default 'application' comment '映射到spring.application.name客户端',
    `profile` varchar(64) default 'dev' comment '映射到spring.profiles.active客户端（逗号分隔的列表）',
    `label` varchar(64) default 'master' comment '这是一个服务器端功能，标记了一组“版本化”的配置文件',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `config_unique` (`application`,`key`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;



insert into config(`key`,value,application,comment)SELECT 'spring.datasource.driver-class-name', 'com.mysql.cj.jdbc.Driver', 'application', 'mysql连接配置'
where not exists(select 1 from config where `key`='spring.datasource.driver-class-name');

insert into config(`key`,value,application,comment)
SELECT 'spring.datasource.url', 'jdbc:mysql://47.111.83.47:3306/blog?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8', 'application', 'mysql连接配置'
where not exists(select 1 from config where `key`='spring.datasource.url');

insert into config(`key`,value,application,comment)SELECT 'spring.datasource.username', 'root', 'application', 'mysql连接配置'
where not exists(select 1 from config where `key`='spring.datasource.username');

insert into config(`key`,value,application,comment)SELECT 'spring.datasource.password', '123456', 'application', 'mysql连接配置'
where not exists(select 1 from config where `key`='spring.datasource.password');

insert into config(`key`,value,application,comment)SELECT 'spring.jpa.database', 'mysql', 'application', 'jpa配置'
where not exists(select 1 from config where `key`='spring.jpa.database');

insert into config(`key`,value,application,comment)SELECT 'spring.jpa.show-sql', 'true', 'application', 'jpa配置'
where not exists(select 1 from config where `key`='spring.jpa.show-sql');

insert into config(`key`,value,application,comment)SELECT 'spring.jpa.properties.hibernate.globally_quoted_identifiers', 'true', 'application', 'jpa配置'
where not exists(select 1 from config where `key`='spring.jpa.properties.hibernate.globally_quoted_identifiers');



insert into config(`key`,value,application,comment)SELECT 'spring.redis.host', '47.111.83.47', 'application', 'redis连接配置'
where not exists(select 1 from config where `key`='spring.redis.host');

insert into config(`key`,value,application,comment)SELECT 'spring.redis.password', '123456', 'application', 'redis连接配置'
where not exists(select 1 from config where `key`='spring.redis.password');

insert into config(`key`,value,application,comment)SELECT 'spring.redis.port', '6380', 'application', 'redis连接配置'
where not exists(select 1 from config where `key`='spring.redis.port');

insert into config(`key`,value,application,comment)SELECT 'spring.redis.database', '0', 'application', 'redis连接配置'
where not exists(select 1 from config where `key`='spring.redis.database');

insert into config(`key`,value,application,comment)SELECT 'spring.redis.timeout', '10000ms', 'application', 'redis连接配置'
where not exists(select 1 from config where `key`='spring.redis.timeout');
