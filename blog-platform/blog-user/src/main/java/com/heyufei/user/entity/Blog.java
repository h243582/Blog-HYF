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
 * 博客文章
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "blog")
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//

    private String title;//文章标题
    @Column(name = "first_picture")
    private String firstPicture;//文章首图，用于随机文章展示
    private String content;//文章正文
    private String description;//描述
    @Column(name = "is_published")
    private Boolean isPublished;//公开或私密
    @Column(name = "is_recommend")
    private Boolean isRecommend;//推荐开关
    @Column(name = "is_appreciation")
    private Boolean isAppreciation;//赞赏开关
    @Column(name = "is_comment_enabled")
    private Boolean is_commentEnabled;//评论开关
    @Column(name = "create_time")
    private java.util.Date createTime;//创建时间
    @Column(name = "update_time")
    private java.util.Date updateTime;//更新时间
    private Integer views;//浏览次数
    private Integer words;//文章字数
    @Column(name = "read_time")
    private Integer readTime;//阅读时长(分钟)
    @Column(name = "category_id")
    private Long categoryId;//文章分类
    @Column(name = "is_top")
    private Boolean isTop;//是否置顶
    private String password;//密码保护
    @Column(name = "user_id")
    private Long userId;//文章作者
}
