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
 * 定时任务日志
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "schedule_job_log")
public class ScheduleJobLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//任务日志id

    @Column(name = "job_id")
    private Long jobId;//任务id

    @Column(name = "bean_name")
    private String beanName;//spring bean名称

    @Column(name = "method_name")
    private String methodName;//方法名
    private String params;//参数
    private Boolean status;//任务执行结果
    private String error;//异常信息
    private Integer times;//耗时（单位：毫秒）

    @Column(name = "create_time")
    private java.util.Date createTime;//创建时间

}
