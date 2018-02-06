package com.sorfwore.zgd.dubbo.user.utils;

import io.jsonwebtoken.*;
import org.joda.time.DateTime;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

/**
 * @author 风骚的GRE
 * @date 2018/1/19.
 */
public class JwtTokenUtil {
    private static Key getKeyInstance(){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
        byte[] dc = DatatypeConverter.parseBase64Binary("gre");
        Key signingKey = new SecretKeySpec(dc,signatureAlgorithm.getJcaName());
        return signingKey;
    }

    /**
     * 生成token的方法
     * @param jwtInfo
     * @param  expire
     */
    public static String generatorToken(JwtInfo jwtInfo,int expire){
        JwtBuilder builder = Jwts.builder()
                .claim(JwtConstants.JWT_KEY_USER_ID,jwtInfo.getUid())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.ES256,getKeyInstance());
        String token = builder.compact();
        return token;
    }

    /**
     * 根据token获得token中的信息
     */
    public static JwtInfo getTokenInfo(String token){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return new JwtInfo((claims.get(JwtConstants.JWT_KEY_USER_ID)).toString());
    }

}
