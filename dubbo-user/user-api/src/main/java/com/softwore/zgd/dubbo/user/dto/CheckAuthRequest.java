package com.softwore.zgd.dubbo.user.dto;

import com.softwore.zgd.dubbo.user.abs.AbstractRequest;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public class CheckAuthRequest extends AbstractRequest implements Serializable {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CheckAuthRequest{" +
                "token='" + token + '\'' +
                '}';
    }
}
