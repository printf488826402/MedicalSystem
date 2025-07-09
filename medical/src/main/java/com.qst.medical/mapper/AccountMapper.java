package com.qst.medical.mapper;

import com.qst.medical.model.AccountModel;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component

public interface AccountMapper {
    /*用户登录security*/
    @Select("select * from account where uname=#{uname} or phonenumber=#{uname}")

    AccountModel securityLogin(String uname);
}
