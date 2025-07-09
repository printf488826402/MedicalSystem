package com.qst.medical.param;

import com.qst.medical.domain.Doctor;
import lombok.Data;

@Data
public class DoctorParam extends Doctor {
    private String pwd;//新增医师的密码
    //省略get/set方法
}
