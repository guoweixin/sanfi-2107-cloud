package com.qfjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.qfjy.mapper"})
public class SanfiMeetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanfiMeetingApplication.class, args);
    }

}
