package com.softwore.zgd.activity.common;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @Description 统一的返回结果
 * @date 2018/1/30.
 */
public class ResultResp<T> implements Serializable{

    private static final long serialVersionUID = 1736830721632998680L;

    /**
     * 返回码
     */
    private ReturnCodeEnum returnCodeEnum;

    /**
     * 某个具体类
     */
    private T result;

    public ReturnCodeEnum getReturnCodeEnum() {
        return returnCodeEnum;
    }

    public void setReturnCodeEnum(ReturnCodeEnum returnCodeEnum) {
        this.returnCodeEnum = returnCodeEnum;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultResp{" +
                "result=" + result +
                ", returnCodeEnum=" + returnCodeEnum +
                '}';
    }

}
