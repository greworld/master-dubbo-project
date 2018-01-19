package com.sorfwore.zgd.dubbo.order.dto;

import com.sorfwore.zgd.dubbo.order.AbstractRequest;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @date 2018.1.18
 */
public class DoOrderRequest extends AbstractRequest implements Serializable{
    private static final long serialVersionUID = -7556838157831899740L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DoOrderRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
