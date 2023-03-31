package com.heyufei.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * 封装了controller返回信息的统一格式
 * @author HeYuFei
 * @since 2023-03-31  11:13
 */
@Getter
@Setter
@NoArgsConstructor
public class Message<T> {
    // 状态码
    private int code;
    // 提示语
    private String msg;
    // 状态(true=成功)
    private boolean status;
    // 对象
    private T t;

    // 对象
    private Map map;

    //跳转页面
    private String path;

    public Message(ErrorCode errorCode) {
        super();
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.status = code < 1400 ? true : false;
    }

    public Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.status = code < 1400 ? true : false;
    }


    public Message(ErrorCode errorCode, T t) {
        super();
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.status = code < 1400 ? true : false;
        this.t = t;
    }

    public Message(ErrorCode errorCode, T t, String path) {
        super();
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.status = code < 1400 ? true : false;
        this.t = t;
        this.path=path;
    }

    public Message(ErrorCode errorCode, T t, Map map) {
        super();
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.status = code < 1400;
        this.t = t;
        this.map=map;
    }

    @Override
    public String toString() {
        return "Message [code=" +
                code +
                ", msg=" +
                msg +
                ", status=" +
                status +
                ", t=" +
                t +
                "]";
    }

}