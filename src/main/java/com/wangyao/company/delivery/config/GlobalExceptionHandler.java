package com.wangyao.company.delivery.config;

import com.wangyao.company.delivery.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author wy
 * Date 2018/9/19 0019
 * Description: 异常统一处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity BusinessExceptionHandler(BusinessException exception) {
        String exceptionMsg = getStackTrace(exception);
        log.error(exceptionMsg);
        Map exceptionMap = new HashMap();
        exceptionMap.put("message", exception.getMessage());
        exceptionMap.put("error", exceptionMsg);
        exceptionMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        exceptionMap.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        return new ResponseEntity<>(exceptionMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity OtherExceptionHandler(Exception  e) {
        String exceptionMsg = getStackTrace(e);
        log.error(exceptionMsg);

        Map exceptionMap = new HashMap();
        exceptionMap.put("message", "系统异常");
        exceptionMap.put("error", exceptionMsg);
        exceptionMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        exceptionMap.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        return new ResponseEntity<>(exceptionMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 获取详细的异常链信息--精准定位异常位置
     * @param aThrowable
     * @return
     */
    public String getStackTrace(Throwable aThrowable) {
        try (Writer result = new StringWriter();
             PrintWriter printWriter = new PrintWriter(result)) {
            aThrowable.printStackTrace(printWriter);
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
