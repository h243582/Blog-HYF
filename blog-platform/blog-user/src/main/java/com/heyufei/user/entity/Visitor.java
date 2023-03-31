package com.heyufei.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 访客记录
 *
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "visitor")
public class Visitor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//

    private String uuid;//访客标识码
    private String ip;//ip
    @Column(name = "ip_source")
    private String ipSource;//ip来源
    private String os;//操作系统
    private String browser;//浏览器
    @Column(name = "create_time")
    private java.util.Date createTime;//首次访问时间
    @Column(name = "last_time")
    private java.util.Date lastTime;//最后访问时间
    private Integer pv;//访问页数统计
    @Column(name = "user_agent")
    private String userAgent;//user-agent用户代理

}
