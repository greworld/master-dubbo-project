package com.sorfwore.zgd.dubbo.user.dto;

import com.sorfwore.zgd.dubbo.user.abs.AbstractRequest;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public class UserRegisterRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = 2800250633253973595L;
    private String username;

    private String password;

    private String mobile;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserRegisterRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
