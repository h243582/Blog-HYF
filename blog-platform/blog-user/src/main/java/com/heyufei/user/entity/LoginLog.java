package com.heyufei.user.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * 登录日志
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Login_log")
public class LoginLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;//用户名称
	private String ip;//ip
	@Column(name = "ip_source")
	private String ipSource;//ip来源
	private String os;//操作系统
	private String browser;//浏览器
	private Boolean status;//登录状态
	private String description;//操作信息
	@Column(name = "create_time")
	private Date createTime;//操作时间
	@Column(name = "user_agent")
	private String userAgent;

	public LoginLog(String username, String ip, boolean status, String description, String userAgent) {
		this.username = username;
		this.ip = ip;
		this.status = status;
		this.description = description;
		this.createTime = new Date();
		this.userAgent = userAgent;
	}
}