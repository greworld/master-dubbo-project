package com.sorfwore.zgd.dubbo.user.dto;

import com.sorfwore.zgd.dubbo.user.abs.AbstractRequest;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public class UserQueryRequest extends AbstractRequest implements Serializable {
    private static final long serialVersionUID = 3621644866824094731L;

    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserQueryRequest{" +
                "uid=" + uid +
                '}';
    }
}
