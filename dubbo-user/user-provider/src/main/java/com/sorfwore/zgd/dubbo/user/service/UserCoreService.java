package com.sorfwore.zgd.dubbo.user.service;

import com.sorfwore.zgd.dubbo.user.IUserCoreService;
import com.sorfwore.zgd.dubbo.user.dto.*;
import org.springframework.stereotype.Service;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
@Service("userLoginService")
public class UserCoreService implements IUserCoreService {
    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        return null;
    }

    @Override
    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        return null;
    }

    @Override
    public CheckAuthResponse checkAuth(CheckAuthRequest request) {
        return null;
    }
}
