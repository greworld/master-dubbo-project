package com.softwore.zgd.activity.service.processor.exception;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public class RewardException extends RuntimeException{
    private static final long serialVersionUID = 5864600208035264264L;
    public RewardException(String msg) {
        super(msg);
    }

    public RewardException(String msg, Throwable e) {
        super(msg, e);
    }

}
