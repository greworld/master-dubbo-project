package com.softwore.zgd.partol.controller.support;

/**
 * @author 风骚的GRE
 * @Descriptions TODO
 * @date 2018/2/4.
 */
public enum ResponseEnum {

    SUCCESS("0","成功"),
    FAILED("1","系统繁忙,请稍后重试"),
    ;
    private String code;
    private String msg;
    private ResponseEnum(String code,String msg){
        this.msg = msg;
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

