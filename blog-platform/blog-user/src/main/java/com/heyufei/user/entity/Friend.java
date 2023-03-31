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
 * 实体类
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "friend")
public class Friend implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//

    private String nickname;//昵称
    private String description;//描述
    private String website;//站点
    private String avatar;//头像
    @Column(name = "is_published")
    private Boolean isPublished;//公开或隐藏
    private Integer views;//点击次数
    @Column(name = "create_time")
    private java.util.Date createTime;//创建时间

}
