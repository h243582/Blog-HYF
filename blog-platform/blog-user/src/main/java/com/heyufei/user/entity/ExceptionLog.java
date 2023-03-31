package com.heyufei.user.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * 异常日志
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "exception_log")
public class ExceptionLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uri;//请求接口
	private String method;//请求方式
	private String param;//请求参数
	private String description;//操作描述
	private String error;//异常信息
	private String ip;//ip
	@Column(name = "ip_source")
	private String ipSource;//ip来源
	private String os;//操作系统
	private String browser;//浏览器
	private Date createTime;//操作时间
	@Column(name = "user_agent")
	private String userAgent;

	public ExceptionLog(String uri, String method, String description, String error, String ip, String userAgent) {
		this.uri = uri;
		this.method = method;
		this.description = description;
		this.error = error;
		this.ip = ip;
		this.createTime = new Date();
		this.userAgent = userAgent;
	}
}
