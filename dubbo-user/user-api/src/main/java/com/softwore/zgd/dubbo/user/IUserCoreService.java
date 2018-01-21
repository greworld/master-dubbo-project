package com.softwore.zgd.dubbo.user;

import com.softwore.zgd.dubbo.user.dto.*;


/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public interface IUserCoreService {

    /**
     * 用户登录操作
     * @param userLoginRequest
     * @return
     */
    public UserLoginResponse login(UserLoginRequest userLoginRequest);


    /*
     * 注册
     */
    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest);


    /**
     * 验证授权
     * @param request
     * @return
     */
    public CheckAuthResponse checkAuth(CheckAuthRequest request);
}
