package com.softwore.zgd.dubbo.user.dto;

import com.softwore.zgd.dubbo.user.abs.AbstractResponse;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public class CheckAuthResponse extends AbstractResponse implements Serializable {
    private static final long serialVersionUID = 2382901341467431499L;
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "CheckAuthResponse{" +
                "uid='" + uid + '\'' +
                '}';
    }
}
