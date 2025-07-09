package com.qst.medical.domain;

//import java.util.Date; // 表示标准的Java日期类，常用于业务逻辑中的日期操作
import com.qst.medical.domain.superdomain.SuperDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;  // 表示SQL专用的日期类，通常用于数据库交互操作
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account extends SuperDomain {
    private Long id;
    private String uname;
    private String pwd;
    private String phoneNumber;
    private String utype;   //取值：ROLE_1：管理员、ROLE_2：医生、ROLE_3：患者
    private Date updatetime;
    private Date createtime;
    private String realname; //真实姓名
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", utype='" + utype + '\'' +
                ", updatetime=" + updatetime +
                ", createtime=" + createtime +
                ", realname='" + realname + '\'' +
                '}';
    }
}
//省略构造方法以及get/set方法
