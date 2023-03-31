package com.heyufei.common.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HeYuFei
 * @since 2023-03-30  15:09
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseMessage<T> {
    //错误码
    private Integer errCode;
    //信息描述
    private String errMsg;
    //具体的信息内容
    private T data;

    public static <T> ResponseMessage<T> success(T object, String message) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.setErrCode(ErrorCodeEnum.SUCCESS.getCode());
        if (message == null) {
            responseMessage.setErrMsg(ErrorCodeEnum.SUCCESS.getMsg());
        } else {
            responseMessage.setErrMsg(message);
        }
        responseMessage.setData(object);
        return responseMessage;
    }

    /**
     * 操作成功不返回消息
     */
    public static <T> ResponseMessage<T> success() {
        return success(null, null);
    }

    public static <T> ResponseMessage<T> success(T obj) {
        return success(obj, null);
    }

    /**
     * 操作失败返回的消息
     */
    public static <T> ResponseMessage<T> error(Integer errorCode, String msg) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.setErrCode(errorCode);
        responseMessage.setErrMsg(msg);
        return responseMessage;
    }

    /**
     * 操作失败返回消息，对error的重载
     */
    public static <T> ResponseMessage<T> error(Integer errorCode) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.setErrCode(errorCode);
        responseMessage.setErrMsg(ErrorCodeEnum.SYSTEM_ERROR.getMsg());
        return responseMessage;
    }

    /**
     * 操作失败返回消息，对error的重载
     */
    public static <T> ResponseMessage<T> error(Integer errorCode, T data) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.setErrCode(errorCode);
        responseMessage.setErrMsg(ErrorCodeEnum.SYSTEM_ERROR.getMsg());
        responseMessage.setData(data);
        return responseMessage;
    }

    public static <T> ResponseMessage<T> error(ErrorCodeEnum errorCodeEnum) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.setErrCode(errorCodeEnum.getHttpCode());
        responseMessage.setErrMsg(errorCodeEnum.getMsg());
        return responseMessage;
    }

    public static <T> ResponseMessage<T> error(ErrorCodeEnum errorCodeEnum, T data) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.setErrCode(errorCodeEnum.getHttpCode());
        responseMessage.setErrMsg(errorCodeEnum.getMsg());
        responseMessage.setData(data);
        return responseMessage;
    }

    public static <T> ResponseMessage<T> error(ErrorCodeEnum errorCodeEnum, String message) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.setErrCode(errorCodeEnum.getHttpCode());
        responseMessage.setErrMsg(message);
        return responseMessage;
    }

    public static <T> ResponseMessage<T> error(ErrorCodeEnum errorCodeEnum, String message, T data) {
        ResponseMessage<T> responseMessage = new ResponseMessage<>();
        responseMessage.setErrCode(errorCodeEnum.getHttpCode());
        responseMessage.setErrMsg(errorCodeEnum.getMsg());
        responseMessage.setErrMsg(message);
        responseMessage.setData(data);
        return responseMessage;
    }
}
