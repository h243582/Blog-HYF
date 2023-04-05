package com.heyufei.gateway.filter;

import com.heyufei.common.result.ResponseMessage;
import com.heyufei.common.util.JacksonUtils;
import com.heyufei.common.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class JwtFilter extends GenericFilterBean {
    @Value(value = "${token.expireTime}")
    private long expireTime;

    @Value(value = "${token.secretKey}")
    private String secretKey;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //后台管理路径外的请求直接跳过
        if (!request.getRequestURI().startsWith(request.getContextPath() + "/admin")) {
            filterChain.doFilter(request, servletResponse);
            return;
        }
        String jwt = request.getHeader("Authorization");
        if (JwtUtils.judgeTokenIsExist(jwt)) {
            try {
                Claims claims = JwtUtils.getTokenBody(jwt, secretKey);
                String username = claims.getSubject();
                List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(token);
            } catch (Exception e) {
                e.printStackTrace();
                response.setContentType("application/json;charset=utf-8");

                PrintWriter out = response.getWriter();
                out.write(JacksonUtils.writeValueAsString(ResponseMessage.error(403,"凭证已失效，请重新登录！")));
                out.flush();
                out.close();
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}