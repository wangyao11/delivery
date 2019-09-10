package com.wangyao.company.delivery.exception;

/**
 * @author liulin
 * @Description BusinessException
 * @date 2018/10/23 0023
 **/
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BusinessException() {
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Throwable ex) {
        super(ex);
    }

    public BusinessException(String msg, Throwable ex) {
        super(msg, ex);
    }
}

