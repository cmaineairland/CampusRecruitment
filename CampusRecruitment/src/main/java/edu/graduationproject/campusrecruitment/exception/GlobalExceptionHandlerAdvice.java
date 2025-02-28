package edu.graduationproject.campusrecruitment.exception;

import edu.graduationproject.campusrecruitment.pojo.responseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 统一处理异常
public class GlobalExceptionHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler({Exception.class}) // 处理所有异常
    public responseMessage handlerException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        // 记录异常日志
        logger.error("Exception: ", e);
        // 使用 responseMessage.error() 返回错误消息
        return responseMessage.error("An error occurred: " + e.getMessage());
    }
}
