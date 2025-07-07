package com.qst.medical.service;

import com.qst.medical.model.AccountModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Overridepublic
UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    AccountModel accountModel = accountMapper.securityLogin(s);
    if (accountModel == null) {
        throw new UsernameNotFoundException("用户不存在");
    }
    String role = accountModel.getUtype();
    List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
    System.out.println(accountModel.getRealname());
    return new AccountModel(accountModel.getId(),accountModel.getUname(),accountModel.getRealname(), role,
            accountModel.getPwd(), auths);
}