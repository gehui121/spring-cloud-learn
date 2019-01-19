package com.itwolf.gateway.utils;

import com.itwolf.gateway.exception.PermissionException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2018/12/23 9:41.
 **/
public class JwtUtil {

    public static final String SECRET = "qazwsx123444$#%#()*&& asdaswwi1235 ?;!@#kmmmpom in***xx**&";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_AUTH = "Authorization";

    /**
     * 生成token
     * @param userName
     * @return
     */
    public static String generateToken(String userName){
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",new Random().nextInt());
        map.put("user",userName);
        String jwt = Jwts.builder()
                .setSubject("user info").setClaims(map)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        String finalJwt = TOKEN_PREFIX + " " +jwt;
        return finalJwt;
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public static Map<String, String> validateToken(String token) throws PermissionException {
        if (token != null){
            HashMap<String, String> map = new HashMap<>();
            Map<String, Object> body = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,""))
                    .getBody();
            String id = String.valueOf(body.get("id"));
            String user = (String) body.get("user");
            map.put("id",id);
            map.put("user",user);
            if (StringUtils.isEmpty(user)){
                //自定义的异常
                throw  new PermissionException("user is empty, please check");
            }
            return map;
        }else {
            throw new PermissionException("token is null, please check");
        }
    }
}
