package com.softwore.zgd.partol.framework.common.exception;

/**
 * @author 风骚的GRE
 * @Descriptions EduFrameWorkException 异常类
 * @date 2018/2/4.
 */
public class EduFrameWorkException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EduFrameWorkException(String message) {
        super(message);
    }

    public EduFrameWorkException(Throwable throwable) {
        super(throwable);
    }

    public EduFrameWorkException(String message, Throwable throwable) {
        super(message, throwable);
    }

}

