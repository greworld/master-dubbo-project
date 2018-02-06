package com.softwore.zgd.dubbo.user.service;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.softwore.zgd.dubbo.user.IUserQueryService;
import com.softwore.zgd.dubbo.user.constants.ResponseCodeEnum;
import com.softwore.zgd.dubbo.user.dal.entity.User;
import com.softwore.zgd.dubbo.user.dal.persistence.UserMapper;
import com.softwore.zgd.dubbo.user.dto.UserQueryRequest;
import com.softwore.zgd.dubbo.user.dto.UserQueryResponse;
import com.softwore.zgd.dubbo.user.exception.ExceptionUtil;
import com.softwore.zgd.dubbo.user.exception.ServiceException;

import com.softwore.zgd.dubbo.user.exception.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
@Service("userQueryService")
public class UserQueryService implements IUserQueryService {
    Logger logger= LoggerFactory.getLogger(UserCoreService.class);
    @Autowired
    private UserMapper userMapper;


    public UserQueryResponse getUserById(UserQueryRequest request) {
        logger.info("begin UserQueryService.getUserById,request:【"+request+"】");
        UserQueryResponse response = new UserQueryResponse();
        try {
            beforeValidate(request);

            response.setCode(ResponseCodeEnum.SYS_SUCCESS.getCode());
            response.setMobile(ResponseCodeEnum.SYS_SUCCESS.getMsg());
            User user = userMapper.getUserByUid(request.getUid());
            if(user!=null){
                response.setAvatar(user.getAvatar());
                response.setSex(user.getSex());
                response.setRealName(user.getRealname());
                response.setMobile(user.getMobile());
                return response;
            }
            response.setCode(ResponseCodeEnum.QUERY_DATA_NOT_EXIST.getCode());
            response.setMsg(ResponseCodeEnum.QUERY_DATA_NOT_EXIST.getMsg());
            return response;
        }catch (Exception e){
            ServiceException serviceException=(ServiceException) ExceptionUtil.handlerException4biz(e);
            response.setCode(serviceException.getErrorCode());
            response.setMsg(serviceException.getErrorMessage());
        }finally {
            logger.info("getUserById response:【"+response+"】");
        }
        return response;
    }

    private void beforeValidate(UserQueryRequest request) {
        if(null==request){
            throw new ValidateException("请求对象为空");
        }
        if(request.getUid()==null||request.getUid().intValue()==0){
            throw new ValidateException("用户id不能为空");
        }
    }


    public UserQueryResponse getUserByIdWithLimiter(UserQueryRequest request) {
        logger.info("begin UserQueryService.getUserByIdWithLimiter,request:【"+request+"】");
        UserQueryResponse response = new UserQueryResponse();
        try {
            beforeValidate(request);
            response.setMsg(ResponseCodeEnum.SYS_SUCCESS.getMsg());
            response.setCode(ResponseCodeEnum.SYS_SUCCESS.getCode());
            User user=userMapper.getUserByUid(request.getUid());
            if (user!=null){
                response.setAvatar(user.getAvatar());
                response.setSex(user.getSex());
                response.setRealName(user.getRealname());
                response.setMobile(user.getMobile());
                return  response;
            }
            response.setCode(ResponseCodeEnum.QUERY_DATA_NOT_EXIST.getCode());
            response.setMsg(ResponseCodeEnum.QUERY_DATA_NOT_EXIST.getMsg());
        }catch (Exception e){
            ServiceException serviceException=(ServiceException) ExceptionUtil.handlerException4biz(e);
            response.setCode(serviceException.getErrorCode());
            response.setMsg(serviceException.getErrorMessage());
        }finally {
            logger.info("getUserByIdWithLimiter response:【"+response+"】");
        }
        return response;
    }
}
