package com.sorfwore.zgd.dubbo.user;

import com.sorfwore.zgd.dubbo.user.dto.UserQueryRequest;
import com.sorfwore.zgd.dubbo.user.dto.UserQueryResponse;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public interface IUserQueryService {
    /**
     * 根据用户id来查询用户信息
     * @param request
     * @return
     */
    public UserQueryResponse getUserById(UserQueryRequest request);

    /**
     * 根据用户id来查询用户信息
     * @param request
     * @return
     */
    public UserQueryResponse getUserByIdWithLimiter(UserQueryRequest request);
}
