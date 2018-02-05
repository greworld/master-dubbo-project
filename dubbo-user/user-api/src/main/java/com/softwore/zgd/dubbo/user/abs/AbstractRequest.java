package com.softwore.zgd.dubbo.user.abs;

import java.io.Serializable;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public abstract class AbstractRequest implements Serializable{
    private static final long serialVersionUID = -7614163468763413304L;

    @Override
    public String toString() {
        return "AbstractRequest{}";
    }
}
