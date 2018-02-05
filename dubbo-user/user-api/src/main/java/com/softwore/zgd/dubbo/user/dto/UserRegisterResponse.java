package com.softwore.zgd.dubbo.user.dto;

import com.softwore.zgd.dubbo.user.abs.AbstractResponse;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public class UserRegisterResponse extends AbstractResponse implements Serializable{
    private static final long serialVersionUID = -8938961392864764535L;
    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserRegisterResponse{" +
                "uid=" + uid +
                '}';
    }
}
