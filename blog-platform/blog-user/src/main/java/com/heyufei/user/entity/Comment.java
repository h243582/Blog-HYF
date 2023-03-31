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
 * 议论
 *
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//

    private String nickname;//昵称
    private String email;//邮箱
    private String content;//评论内容
    private String avatar;//头像(图片路径)
    @Column(name = "create_time")
    private java.util.Date createTime;//评论时间
    private String ip;//评论者ip地址
    @Column(name = "is_published")
    private Boolean isPublished;//公开或回收站
    @Column(name = "is_admin_comment")
    private Boolean isAdminComment;//博主回复
    private Integer page;//0普通文章，1关于我页面，2友链页面
    @Column(name = "is_notice")
    private Boolean isNotice;//接收邮件提醒
    @Column(name = "blog_id")
    private Long blogId;//所属的文章
    @Column(name = "parent_comment_id")
    private Long parentCommentId;//父评论id，-1为根评论
    private String website;//个人网站
    private String qq;//如果评论昵称为QQ号，则将昵称和头像置为QQ昵称和QQ头像，并将此字段置为QQ号备份

}
