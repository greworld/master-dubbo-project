package com.sorfwore.zgd.dubbo.user.utils;

/**
 * @author 风骚的GRE
 * @date 2018/1/19.
 */
public class JwtInfo {
    private String uid;

    public JwtInfo(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
