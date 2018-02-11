package com.greworld.framework.exception;

/**
 * @author 风骚的GRE
 * @Description MybatisPluginsException异常类
 * @date 2018/1/29.
 */
public class MybatisPluginsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MybatisPluginsException(String message) {
        super(message);
    }

    public MybatisPluginsException(Throwable throwable) {
        super(throwable);
    }

    public MybatisPluginsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
