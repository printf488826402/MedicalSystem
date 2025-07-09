package com.qst.medical.model;

import com.qst.medical.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Data
//@AllArgsConstructor
/*
* Lombok 无法处理父类字段的构造逻辑,全参构造器要自己手写
* */
@NoArgsConstructor
public class AccountModel extends Account implements UserDetails {
    private String urealName; //用户真实姓名
    private Collection<? extends GrantedAuthority> authorities; //认证集
    @Override
    public String getPassword() {return this.getPwd();} // 调用父类 Account 的 getPwd()
    @Override
    public String getUsername() {return this.getUname();} // 调用父类 Account 的 getUname()
    /*
    @Data 只会自动生成字段相关的 getter/setter/toString 等，不会自动帮你实现接口方法。
    所以即使用了 Lombok，只要接口中有抽象方法，就必须手动实现它们。
    如果你不实现 getPassword() 和 getUsername()，也 不能省略 abstract 关键字，否则编译失败。
    */


    public AccountModel(Long id, String uname,String realname, String role, String pwd, Collection<? extends GrantedAuthority> authorities) {
        this.setId(id);
        this.setUname(uname);
        this.setUtype(role);
        this.setUrealName(realname);
        this.setPwd(pwd);
        this.authorities = authorities;
    }//手写全参构造器UserDetailsServiceImpl不会报错
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}