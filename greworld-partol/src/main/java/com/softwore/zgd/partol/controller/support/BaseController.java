package com.softwore.zgd.partol.controller.support;

/**
 * @author 风骚的GRE
 * @Descriptions TODO
 * @date 2018/2/4.
 */
public class BaseController {
    ThreadLocal<String> uidLocal=new ThreadLocal<>();

    public String getUid(){
        return uidLocal.get();
    }

    public void setUid(String uid){
        uidLocal.set(uid);
    }

}
