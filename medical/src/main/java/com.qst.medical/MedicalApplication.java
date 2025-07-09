package com.qst.medical;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.swing.*;

@SpringBootApplication
//@MapperScan("com.qst.medical")
/*
在每个 Mapper 层文件上加上 @Component或@Mapper，Spring 会识别它为 Bean 并注册到容器中
所以 该注解可忽略
*/
public class MedicalApplication {

    public static void main(String[] args) {

        SpringApplication.run(MedicalApplication.class, args);
    }

}
