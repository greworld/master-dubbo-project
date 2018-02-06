package com.softwore.zgd.dubbo.user.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        byte[] dc=DatatypeConverter.parseBase64Binary("gupao-user");
        return new SecretKeySpec(dc,signatureAlgorithm.getJcaName());
    }

    //生成token的方法
    public static String generatorToken(JwtInfo jwtInfo,int expire){

        return Jwts.builder().claim(JwtConstants.JWT_KEY_USER_ID,jwtInfo.getUid())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.HS256,getKeyInstance()).compact();
    }


    //根据token获得token中的信息
    public static JwtInfo getTokenInfo(String token){
        Jws<Claims> claimsJws=Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(token);
        Claims claims=claimsJws.getBody();
        return new JwtInfo((claims.get(JwtConstants.JWT_KEY_USER_ID)).toString());
    }


}
