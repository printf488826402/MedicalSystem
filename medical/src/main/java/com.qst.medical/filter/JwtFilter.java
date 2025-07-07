package com.qst.medical.filter;

import com.qst.medical.model.AccountModel;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Override
protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
    String token = httpServletRequest.getHeader("Authorization");
    httpServletResponse.setContentType("text/json;charset=utf-8");
    if (StringUtils.hasLength(token)) {
        String uname = null;
        try {
            uname = (String) JwtUtils.getClaims(token).get("uname");
            System.out.println(uname);
        }
        catch (ExpiredJwtException e) {
            logger.info("失效身份");
        }
        if (uname != null) {
            String role = (String) JwtUtils.getClaims(token).get("role");
            UserDetails userDetails = userDetailService.loadUserByUsername(uname);
            AccountModel model = (AccountModel) userDetails;
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);                			 UsernamePasswordAuthenticationToken authenticationFilter = new UsernamePasswordAuthenticationToken(model, null, grantedAuthorities);
            authenticationFilter.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));                SecurityContextHolder.getContext().setAuthentication(authenticationFilter);
        }
    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);
}
