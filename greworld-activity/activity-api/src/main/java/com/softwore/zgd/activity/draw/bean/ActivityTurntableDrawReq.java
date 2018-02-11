package com.softwore.zgd.activity.draw.bean;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public class ActivityTurntableDrawReq implements Serializable{
    private static final long serialVersionUID = -1847930887525256465L;
    private Integer uid;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "ActivityTurntableDrawReq{" +
                "uid=" + uid +
                '}';
    }

}
