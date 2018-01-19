package com.sorfwore.zgd.dubbo.user.abs;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public abstract class AbstractResponse implements Serializable{
    private static final long serialVersionUID = 6900008219277143421L;
    /**
     * 返回码（请求）
     */
    private String code;

    private String msg;

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

    @Override
    public String toString() {
        return "AbstractResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
