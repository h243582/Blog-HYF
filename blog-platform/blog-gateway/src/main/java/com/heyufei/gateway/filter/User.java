package com.heyufei.gateway.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;//用户名
    private String password;//密码
    private String nickname;//昵称
    private String avatar;//头像地址
    private String email;//邮箱
    @Column(name = "create_time")
    private java.util.Date create_time;//创建时间
    @Column(name = "update_time")
    private java.util.Date update_time;//更新时间
    private String role;//角色访问权限
}
