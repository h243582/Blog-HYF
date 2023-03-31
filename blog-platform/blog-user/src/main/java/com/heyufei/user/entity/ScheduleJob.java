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
 * 定时任务
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "schedule_job")
public class ScheduleJob implements Serializable {
    public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY"; //任务调度参数key

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;//任务id
    @Column(name = "bean_name")
    private String beanName;//spring bean名称
    @Column(name = "method_name")
    private String methodName;//方法名
    private String params;//参数
    private String cron;//cron表达式
    private Boolean status;//任务状态
    private String remark;//备注
    @Column(name = "create_time")
    private java.util.Date create_time;//创建时间

}
