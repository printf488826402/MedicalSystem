package com.qst.medical.domain;

import com.qst.medical.domain.superdomain.SuperDomain;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/*
javax.validation.constraints.NotNull：用于通用的数据校验，确保对象不为 null。
com.sun.istack.NotNull 和 com.sun.istack.internal.NotNull：主要用于 JAXB 的 XML 绑定和序列化过程，确保 XML 元素或属性不为 null。
* */
import javax.validation.constraints.Pattern;
import java.util.Date;
/*
java.util.Date：通用的日期类，用于处理一般的日期和时间操作。
java.sql.Date：专门用于与数据库中的日期类型进行交互，只包含日期部分。
sun.util.calendar.BaseCalendar.Date 和 sun.util.calendar.LocalGregorianCalendar.Date：JDK 内部使用的类，不应在应用代码中直接使用。
* */
@Data
public class Doctor extends SuperDomain {
    private Long id;//医师id
    @NotBlank(message = "姓名不能为空")
    @Pattern(regexp = "(^[\u2E80-\u9FFF]{2,4})",message = "姓名只能为汉字,且长度为2-4个汉字")
    private String name;//医师姓名
    @Range(min = 1, max = 130, message = "年龄格式错误")
    @NotNull(message = "年龄不能为空")
    private Integer age;//年龄
    @Range(min = 1, max = 2, message = "性别错误，1代表男，2代表女")
    @NotNull(message = "性别不能为空")
    private Integer sex;//性别：1男，2女
    @NotNull(message = "等级不能为空")
    private Integer levelId;//等级：1主任，2普通
    @NotBlank(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号格式不正确")
    private String phoneNumber;//电话号
    @NotNull(message = "级别不能为空")
    private Long typeId;//诊治类别id
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private Long accountId;//账号id
}
