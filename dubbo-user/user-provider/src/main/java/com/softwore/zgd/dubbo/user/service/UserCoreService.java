package com.softwore.zgd.dubbo.user.service;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.softwore.zgd.dubbo.user.IUserCoreService;
import com.softwore.zgd.dubbo.user.constants.Constants;
import com.softwore.zgd.dubbo.user.constants.ResponseCodeEnum;
import com.softwore.zgd.dubbo.user.dal.entity.User;
import com.softwore.zgd.dubbo.user.dal.persistence.UserMapper;
import com.softwore.zgd.dubbo.user.dto.*;
import com.softwore.zgd.dubbo.user.exception.ExceptionUtil;
import com.softwore.zgd.dubbo.user.exception.ServiceException;
import com.softwore.zgd.dubbo.user.exception.ValidateException;
import com.softwore.zgd.dubbo.user.utils.JwtInfo;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
@Service("userLoginService")
public class UserCoreService implements IUserCoreService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtTokenService jwtTokenService;

    Logger logger= LoggerFactory.getLogger(UserCoreService.class);

    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        logger.info("begin UserCoreService.login,request:【"+userLoginRequest+"】");
        UserLoginResponse response=new UserLoginResponse();
        try {
            beforeValidate(userLoginRequest);
            User user = userMapper.getUserByUserName(userLoginRequest.getUsername());
            if(user==null||!user.getPassword().equals(userLoginRequest.getPassword())){
                response.setCode(ResponseCodeEnum.USER_OR_PASSWORD_ERROR.getCode());
                response.setMsg(ResponseCodeEnum.USER_OR_PASSWORD_ERROR.getMsg());
                return response;
            }
            // TODO 判断用户状态
            response.setAvatar(user.getAvatar());
            response.setMobile(user.getMobile());
            response.setRealName(user.getRealname());
            response.setSex(user.getSex());

            // TODO 生成token
            response.setToken(jwtTokenService.generatorToken(new JwtInfo(user.getId().toString())));
            response.setCode(ResponseCodeEnum.SYS_SUCCESS.getCode());
            response.setMsg(ResponseCodeEnum.SYS_SUCCESS.getMsg());
            return response;
        }catch (Exception e){
            ServiceException serviceException=(ServiceException) ExceptionUtil.handlerException4biz(e);
            response.setCode(serviceException.getErrorCode());
            response.setMsg(serviceException.getErrorMessage());
        }finally {
            logger.info("login response:【"+response+"】");
        }
        return response;
    }


    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        logger.info("begin UserCoreService.register,request:【"+userRegisterRequest+"】");
        UserRegisterResponse response = new UserRegisterResponse();
        try {
            beforeRegisterValidate(userRegisterRequest);
            User user = new User();
            user.setUsername(userRegisterRequest.getUsername());
            user.setPassword(userRegisterRequest.getPassword());
            user.setStatus(Constants.FORZEN_USER_STATUS);
            user.setCreateTime(new Date());
            int effectRow = userMapper.insertSelective(user);
            if (effectRow > 0){
                response.setCode(ResponseCodeEnum.SYS_SUCCESS.getCode());
                response.setMsg(ResponseCodeEnum.SYS_SUCCESS.getMsg());
                return  response;
            }
            response.setCode(ResponseCodeEnum.DATA_SAVE_ERROR.getCode());
            response.setMsg(ResponseCodeEnum.DATA_SAVE_ERROR.getMsg());
            return  response;
        }catch (DuplicateKeyException e){
            //TODO 用户名重复

        }catch (Exception e){
            ServiceException serviceException = (ServiceException) ExceptionUtil.handlerException4biz(e);
            response.setCode(serviceException.getErrorCode());
            response.setMsg(serviceException.getErrorMessage());
        }finally {
            logger.info("register response:【"+response+"】");
        }
        return response;
    }

    public CheckAuthResponse checkAuth(CheckAuthRequest request) {
        logger.info("begin CheckAuthResponse.checkAuth,request:【"+request+"】");
        CheckAuthResponse response = new CheckAuthResponse();
        try {
            beforeChaeckAuthValidate(request);
            JwtInfo jwtInfo = jwtTokenService.getInfoFromToken(request.getToken());
            response.setUid(jwtInfo.getUid());
            response.setCode(ResponseCodeEnum.SYS_SUCCESS.getCode());
            response.setMsg(ResponseCodeEnum.SYS_SUCCESS.getMsg());

        }catch (ExpiredJwtException e){
            //TODO
            logger.error("error",e);
        }catch (SignatureException e){
            logger.error("error",e);
        }catch (Exception e){
            ServiceException serviceException=(ServiceException) ExceptionUtil.handlerException4biz(e);
            response.setCode(serviceException.getErrorCode());
            response.setMsg(serviceException.getErrorMessage());
        }finally {
            logger.info("checkAuth response:【"+response+"】");
        }
        return response;
    }

    private void beforeChaeckAuthValidate(CheckAuthRequest request) {
        if(null==request){
            throw new ValidateException("请求对象为空");
        }
        if(StringUtils.isEmpty(request.getToken())){
            throw new ValidateException("token信息为空");
        }
    }


    private void beforeValidate(UserLoginRequest userLoginRequest) {
        if(null==userLoginRequest){
            throw new ValidateException("请求对象为空");
        }
        if(StringUtils.isEmpty(userLoginRequest.getUsername())){
            throw new ValidateException("用户名为空");
        }
        if(StringUtils.isEmpty(userLoginRequest.getPassword())){
            throw new ValidateException("密码为空");
        }
    }

    private void beforeRegisterValidate(UserRegisterRequest userRegisterRequest) {
        if(null==userRegisterRequest){
            throw new ValidateException("请求对象为空");
        }
        if(StringUtils.isEmpty(userRegisterRequest.getUsername())){
            throw new ValidateException("用户名为空");
        }
        if(StringUtils.isEmpty(userRegisterRequest.getPassword())){
            throw new ValidateException("密码为空");
        }
        if(StringUtils.isEmpty(userRegisterRequest.getMobile())){
            throw new ValidateException("手机号为空");
        }
    }
}
