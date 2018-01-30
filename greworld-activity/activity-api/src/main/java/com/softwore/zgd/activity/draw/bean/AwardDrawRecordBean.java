package com.softwore.zgd.activity.draw.bean;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public class AwardDrawRecordBean implements Serializable{
    private static final long serialVersionUID = -8132839521219108461L;
    private Integer id;

    private Integer uid;

    private String name;

    private Integer level; //中奖等级


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}
