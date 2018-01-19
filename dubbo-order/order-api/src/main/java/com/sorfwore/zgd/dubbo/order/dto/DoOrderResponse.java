package com.sorfwore.zgd.dubbo.order.dto;

import com.sorfwore.zgd.dubbo.order.AbstractResponse;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public class DoOrderResponse extends AbstractResponse implements Serializable{
    private static final long serialVersionUID = -1545447973458383894L;
    private Object data;

    private String code;

    private String memo;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "DoOrderResponse{" +
                "data=" + data +
                ", code='" + code + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
