package com.heyufei.common.result;

/**
 * @author HeYuFei
 * @since 2023-03-30  15:13
 */
public enum ErrorCodeEnum {
    SUCCESS(0, 200, "Success"),
    INVALID_PARAM(5, 400, "Invalid Parameter"),
    UNAUTHORIZED(3, 401, "Unauthorized"),
    LICENSE_FORBIDDEN(6, 403, "License Forbidden"),
    LICENSE_EXPIRED(7, 403, "License Expired"),
    FORBIDDEN(2, 403, "Forbidden"),
    NOT_FOUND(4, 404, "Not Found"),
    METHOD_NOT_ALLOWED(8, 405, "HTTP Method Not Allowed"),
    TOO_MANY_REQUESTS(12, 429, "Too Many Requests"),
    SYSTEM_ERROR(1, 500, "Internal Server Error"),
    MEDIA_NOT_SUPPORTED(9, 415, "Media Type Not Supported"),
    FORWARDING_ERROR(10, 502, "Forwarding Error"),
    GATEWAY_TIMEOUT(11, 504, "Gateway Timeout"),
    ;

    private Integer code;
    private Integer httpCode;
    private String msg;

    ErrorCodeEnum(Integer code, Integer httpCode, String msg) {
        this.code = code;
        this.httpCode = httpCode;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public String getMsg() {
        return msg;
    }
}
