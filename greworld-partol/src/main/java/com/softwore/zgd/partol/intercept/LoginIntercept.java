package com.softwore.zgd.partol.intercept;

import com.alibaba.fastjson.JSONObject;
import com.softwore.zgd.dubbo.user.IUserCoreService;
import com.softwore.zgd.dubbo.user.dto.CheckAuthRequest;
import com.softwore.zgd.dubbo.user.dto.CheckAuthResponse;
import com.softwore.zgd.partol.controller.annotations.Anonymous;
import com.softwore.zgd.partol.controller.support.BaseController;
import com.softwore.zgd.partol.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author 风骚的GRE
 * @Descriptions 登录的拦截器
 * @date 2018/2/4.
 */
public class LoginIntercept extends HandlerInterceptorAdapter{
    private final String ACCESS_TOKEN="access_token";

    @Autowired
    IUserCoreService userCoreService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Object action = handlerMethod.getBean();
        if(!(action instanceof BaseController)){
            throw new Exception("异常");
        }

        if(isAnonymous(handlerMethod)){
            return true;
        }
        String accessToken= CookieUtil.getCookieValue(request,ACCESS_TOKEN);
        //没有登录情况的判断
        if (StringUtils.isEmpty(accessToken)){
            if (CookieUtil.isAjax(request)){
                JSONObject object=new JSONObject();
                object.put("code","-1");
                object.put("msg","没有登录");
                response.getWriter().write(object.toJSONString());
                return false;
            }
            response.sendRedirect("/login.shtml");
            return false;
        }
        CheckAuthRequest checkAuthRequest = new CheckAuthRequest();
        checkAuthRequest.setToken(accessToken);

        CheckAuthResponse checkAuthResponse = userCoreService.checkAuth(checkAuthRequest);
        if("000000".equals(checkAuthResponse.getCode())){
            ((BaseController)action).setUid(checkAuthResponse.getUid());
            return true;
        }
        return false;


    }

    private boolean isAnonymous(HandlerMethod handlerMethod) {
        Object action=handlerMethod.getBean();
        Class clazz=action.getClass();
        if(clazz.getAnnotation(Anonymous.class)!=null){
            return true;
        }
        Method method=handlerMethod.getMethod();
        return method.getAnnotation(Anonymous.class)!=null;

    }
}
