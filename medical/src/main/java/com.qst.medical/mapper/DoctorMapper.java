package com.qst.medical.mapper;

import com.qst.medical.model.DoctorLevelModel;
import com.qst.medical.model.DoctorModel;
import com.qst.medical.param.DoctorParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DoctorMapper {
    /*获取所有的医师信息*/
//    List<DoctorModel> getAllDoctor(DoctorParam param);
//    /*获取所有的医师级别*/
//    List<DoctorLevelModel> getAllLevel();
//    /*获取所有的诊治类型*/
//    List<TreatTypeModel>
//    getAllTreatType();
}




//package com.qst.medical.mapper;
//
//import com.qst.medical.model.DoctorModel;
//import com.qst.medical.model.DoctorLevelModel;
//import com.qst.medical.model.TreatTypeModel;
//import com.qst.medical.param.DoctorParam;
//import org.apache.ibatis.annotations.*;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@Mapper
//public interface DoctorMapper {
//
//    /**
//     * 获取所有的医师信息（支持关键字查询）
//     */
//    @SelectProvider(type = DoctorSqlProvider.class, method = "getAllDoctor")
//    @Results(id = "getAllDoctorMap", value = {
//            @Result(property = "id", column = "id"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "age", column = "age"),
//            @Result(property = "sex", column = "sex"),
//            @Result(property = "doctorLevel", column = "lname"),
//            @Result(property = "phoneNumber", column = "phone"),
//            @Result(property = "accountId", column = "account_id"),
//            @Result(property = "typeId", column = "tid"),
//            @Result(property = "treatType", column = "tname")
//    })
//    List<DoctorModel> getAllDoctor(DoctorParam param);
//
//    /**
//     * 获取所有的医师级别
//     */
//    @Select("SELECT id, name FROM doctor_level")
//    @Results(value = {
//            @Result(property = "id", column = "id"),
//            @Result(property = "name", column = "name")
//    })
//    List<DoctorLevelModel> getAllLevel();
//
//    /**
//     * 获取所有的诊治类型
//     */
//    @Select("SELECT id, name FROM treat_type")
//    @Results(value = {
//            @Result(property = "id", column = "id"),
//            @Result(property = "name", column = "name")
//    })
//    List<TreatTypeModel> getAllTreatType();
//}
