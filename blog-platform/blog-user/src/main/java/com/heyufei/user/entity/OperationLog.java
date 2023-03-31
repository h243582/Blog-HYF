package com.heyufei.user.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * 操作日志
 * @author Administrator
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "operation_log")
public class OperationLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;//操作者用户名
	private String uri;//请求接口
	private String method;//请求方式
	private String param;//请求参数
	private String description;//操作描述
	private String ip;//ip
	@Column(name = "ip_source")
	private String ipSource;//ip来源
	private String os;//操作系统
	private String browser;//浏览器
	private Integer times;//请求耗时（毫秒）

	@Column(name = "create_time")
	private Date createTime;//操作时间

	@Column(name = "user_agent")
	private String userAgent;

	public OperationLog(String username, String uri, String method, String description, String ip, Integer times, String userAgent) {
		this.username = username;
		this.uri = uri;
		this.method = method;
		this.description = description;
		this.ip = ip;
		this.times = times;
		this.createTime = new Date();
		this.userAgent = userAgent;
	}
}
