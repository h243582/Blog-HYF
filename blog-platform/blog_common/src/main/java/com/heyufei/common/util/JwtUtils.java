package com.heyufei.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

/**
 * JWT工具类
 *
 * @author HeYuFei
 * @since 2023-03-31  14:17
 */
public final class JwtUtils {
    private JwtUtils() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     * 判断token是否存在
     */
    public static boolean judgeTokenIsExist(String token) {
        return token != null && !"".equals(token) && !"null".equals(token);
    }

    /**
     * 生成token
     */
    public static String generateToken(String subject, long expireTime, String secretKey) {
        String jwt = Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
        return jwt;
    }

    /**
     * 生成带角色权限的token
     */
    public static String generateToken(String subject, Collection<? extends GrantedAuthority> authorities, long expireTime, String secretKey) {
        StringBuilder sb = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            sb.append(authority.getAuthority()).append(",");
        }
        String jwt = Jwts.builder()
                .setSubject(subject)
                .claim("authorities", sb)
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
        return jwt;
    }

    /**
     * 获取tokenBody同时校验token是否有效（无效则会抛出异常）
     */
    public static Claims getTokenBody(String token, String secretKey) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token.replace("Bearer", "")).getBody();
        return claims;
    }
}
