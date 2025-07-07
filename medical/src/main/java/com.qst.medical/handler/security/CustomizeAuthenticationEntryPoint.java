package com.qst.medical.handler.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qst.medical.model.AccountInfoModel;
import com.qst.medical.model.AccountModel;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Componentpublic class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(Msg.fail().mess("未登录或登录失效").code(10006)));    			      	}
}
@Componentpublic class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(Msg.fail().code(10007).mess("无访问权限")));
    }
}
@Componentpublic class MyAuthenticationFailHandler implements AuthenticationFailureHandler {
    private static Logger logger = Logger.getLogger(MyAuthenticationFailHandler.class);
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        logger.info("MyAuthenticationFailHandler.request: "+request);
        logger.info("MyAuthenticationFailHandler.response: "+response);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(Msg.fail().mess("用户名或密码错误")));
    }
}
@Componentpublic class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("text/json;charset=utf-8");
        AccountModel model = (AccountModel) authentication.getPrincipal();
        String jwtToken = JwtUtils.getJwtToken(model.getId(), model.getUname(), model.getUtype());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AccountInfoModel info = new AccountInfoModel();
        info.setRealname(model.getUrealName());
        info.setUtype(model.getUtype());
        info.setUtype(info.getUtype().substring("ROLE_".length()));
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(Msg.success().mess("登陆成功").data("token",jwtToken).data("userInfo", info)));
    }
}
