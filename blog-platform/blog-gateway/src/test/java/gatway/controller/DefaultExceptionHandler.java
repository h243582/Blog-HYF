package gatway.controller;

import com.heyufei.common.exception.BaseException;
import com.heyufei.common.exception.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 创建全局异常捕捉类
 * @author HeYuFei
 * @since 2023-03-31  11:11
 */
@RestControllerAdvice
public class DefaultExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(BaseException.class)
    public Message handlerSellerException(BaseException e) {
        logger.error("订单模块异常:{}",e.getMessage());
        return new Message(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Message processRuntimeException(RuntimeException e) {
        e.printStackTrace();
        logger.error("运行时异常:{}",e.getMessage());
        return new Message(1604,"操作失败");
    }

    @ExceptionHandler(Exception.class)
    public Message processException(Exception e) {
        e.printStackTrace();
        logger.error("系统异常:{}",e.getMessage());
        return new Message(1604,"操作失败");
    }
}