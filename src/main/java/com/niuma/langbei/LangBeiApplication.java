package com.niuma.langbei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author changwei
 */
@SpringBootApplication
@MapperScan("com.niuma.langbei.mapper")
@EnableScheduling
public class LangBeiApplication{
    public static void main(String[] args) {
        SpringApplication.run(LangBeiApplication.class, args);
    }
}
