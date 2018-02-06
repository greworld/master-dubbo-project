package com.softwore.zgd.dubbo.user.service;

import com.softwore.zgd.dubbo.user.utils.JwtInfo;
import com.softwore.zgd.dubbo.user.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 风骚的GRE
 * @date 2018/1/19.
 */
@Component
public class JwtTokenService {
    @Value("${jwt.expire}")
    private int expire;

    public String generatorToken(JwtInfo jwtInfo){
        return JwtTokenUtil.generatorToken(jwtInfo,expire);
    }

    public JwtInfo getInfoFromToken(String token){
        return JwtTokenUtil.getTokenInfo(token);
    }
}

