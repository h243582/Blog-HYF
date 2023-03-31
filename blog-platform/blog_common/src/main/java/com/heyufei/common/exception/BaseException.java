package com.heyufei.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author HeYuFei
 * @since 2023-03-31  10:50
 */
@Getter
@Setter
@NoArgsConstructor
public class BaseException extends RuntimeException {
    private Integer code;
    private String message;


    public BaseException(String message){
        super(message);
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 定义枚举类，以错误码加信息的形式返回
     */
    public BaseException(ErrorCode errorCode) {
        this.message = errorCode.getMsg();
        this.code = errorCode.getCode();
    }

}