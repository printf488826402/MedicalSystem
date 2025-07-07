package com.qst.medical.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//import java.sql.Date;

public static String getJwtToken(Long id, String uname, String role){
    String JwtToken = Jwts.builder()
            .setHeaderParam("typ","JWT")  //jwet头信息
            .setHeaderParam("alg","HS256")
            .setSubject("medical-user")  //分类（自定义）
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
            .claim("id",id)  //token载体（用户id和用户名）
            .claim("uname", uname)
            .claim("role", role)
            .signWith(SignatureAlgorithm.HS256,APP_SECRET)
            .compact();
    return JwtToken;
}
public static boolean checkToken(String jwtToken) {
    if(!StringUtils.hasLength(jwtToken)) return false;
    try {
        Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
    }catch (Exception e) {
        //e.printStackTrace();
        return false;
    }
    return true;
}
public static boolean checkToken(HttpServletRequest request) {
    try {
        String jwtToken = request.getHeader("token");
        if(!StringUtils.hasLength(jwtToken)) return false;
        Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
    }
    catch (Exception e) {
        //e.printStackTrace();
        return false;
    }
    return true;
}
public static Claims getClaims(String jwtToken) {
    if(!StringUtils.hasLength(jwtToken))
        return null;
    Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
    Claims claims = claimsJws.getBody();
    return claims;
}
public static String getMemberIdByJwtToken(HttpServletRequest request) {
    String jwtToken = request.getHeader("token");
    if(!StringUtils.hasLength(jwtToken)) return "";
    Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
    Claims claims = claimsJws.getBody();
    return (String)claims.get("id");
}