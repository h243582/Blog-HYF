DROP TABLE IF EXISTS `user`;
CREATE TABLE if not exists `user`
(
    `id`          bigint(0)                                                     NOT NULL AUTO_INCREMENT,
    `username`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
    `password`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
    `nickname`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
    `avatar`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  COMMENT '头像地址',
    `email`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  COMMENT '邮箱',
    `create_time` datetime(0)                                                    COMMENT '创建时间',
    `update_time` datetime(0)                                                    COMMENT '更新时间',
    `role`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  COMMENT '角色访问权限',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;


INSERT INTO user(username, password, nickname, avatar, email, create_time, update_time, role)
SELECT 'Admin', '$2a$10$4wnwMW8Z4Bn6wR4K1YlbquQunlHM/4rvudVBX8oyfx16xeVtI6i7C', 'Admin', '/img/avatar.jpg', 'admin@naccl.top', now(), now(), 'ROLE_admin'
where not exists(select 1 from user where id=1 and username='Admin');
                                                                                                      ;

