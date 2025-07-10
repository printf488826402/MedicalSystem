package com.qst.medical.domain;

import com.qst.medical.domain.superdomain.SuperDomain;
import lombok.Data;

@Data
public class TreatType extends SuperDomain {
    private Long id;//诊治类型id
    private String name;//诊治类型名称
    //省略get/set方法
}