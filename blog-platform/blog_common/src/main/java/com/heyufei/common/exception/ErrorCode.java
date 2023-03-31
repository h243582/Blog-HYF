package com.heyufei.common.exception;

/**
 * 错误码枚举（code<1400为成功；code>=1400为失败）
 * @author HeYuFei
 * @since 2023-03-31  11:03
 */
public enum ErrorCode {
    SUCCESS(1200, "操作成功"),
    ERROR_LOGIN(1600, "登录失败"),
    ERROR_LOGIN_PASSWORD(1601, "账号或密码错误"),
    ERROR_LOGIN_NULL(1602, "用户不存在"),
    SUCCESS_LOGGED(1203,"已登录"),
    ERROR(1500, "操作失败"),

    ERROR_TOKEN(1602,"TOKEN失效或者错误"),
    ERROR_ARG(1601, "参数错误"),
    ERROR_AUTH(1606, "认证失败"),
    ERROR_QUERY(1608, "数据丢失");

    private final int code;
    private final String msg;

    private ErrorCode(final int code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}