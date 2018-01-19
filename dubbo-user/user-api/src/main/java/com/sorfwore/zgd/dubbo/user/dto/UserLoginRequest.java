package com.sorfwore.zgd.dubbo.user.dto;

import com.sorfwore.zgd.dubbo.user.abs.AbstractRequest;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public class UserLoginRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = 6717554289175758283L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
