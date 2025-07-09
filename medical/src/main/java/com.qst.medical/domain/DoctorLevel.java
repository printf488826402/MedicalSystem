package com.qst.medical.domain;

import com.qst.medical.domain.superdomain.SuperDomain;
import lombok.Data;

@Data
public class DoctorLevel extends SuperDomain {
    private Long id;//级别id
    private String name;//级别名称
}
