package com.greworld.zgd.controller;

import com.greworld.zgd.controller.support.ResponseData;
import com.softwore.zgd.dubbo.user.constants.ResponseCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 风骚的GRE
 * @Description 请求处理的基类
 * @date 2018/1/29.
 */
public class BaseController {
    public Logger LOG= LoggerFactory.getLogger(BaseController.class);


    protected String redirectTo(String url) {
        StringBuffer rto = new StringBuffer("redirect:");
        rto.append(url);
        return rto.toString();
    }

    protected ResponseData setEnumResult(ResponseCodeEnum anEnum, Object data){
        ResponseData res =new ResponseData();
        res.setCode(anEnum.getCode());
        res.setData(data);
        res.setMessage(anEnum.getMsg());
        return res;
    }
}
