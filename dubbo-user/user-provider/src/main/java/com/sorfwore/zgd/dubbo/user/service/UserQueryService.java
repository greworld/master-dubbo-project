package com.sorfwore.zgd.dubbo.user.service;

import com.sorfwore.zgd.dubbo.user.IUserQueryService;
import com.sorfwore.zgd.dubbo.user.dto.UserQueryRequest;
import com.sorfwore.zgd.dubbo.user.dto.UserQueryResponse;
import org.springframework.stereotype.Service;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
@Service("userQueryService")
public class UserQueryService implements IUserQueryService {
    @Override
    public UserQueryResponse getUserById(UserQueryRequest request) {
        return null;
    }

    @Override
    public UserQueryResponse getUserByIdWithLimiter(UserQueryRequest request) {
        return null;
    }
}
