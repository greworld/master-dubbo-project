package com.softwore.zgd.activity.service.processor.exception;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public class UnRewardException extends RuntimeException {

    private static final long serialVersionUID = -8140196131754350993L;

    public UnRewardException(String msg) {
        super(msg);
    }

    public UnRewardException(String msg, Throwable e) {
        super(msg, e);
    }

}
