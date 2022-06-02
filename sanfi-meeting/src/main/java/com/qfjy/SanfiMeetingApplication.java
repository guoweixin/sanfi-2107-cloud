package com.qfjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient  // @EnableDiscoveryClient
@EnableHystrix  //Hystrix组件  @EnableCircuitBreaker

@MapperScan(basePackages = {"com.qfjy.mapper"})

@EnableFeignClients  //Feign组件 注解声效


//组合注解：SpringCloudApplication
//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker
//@SpringCloudApplication
public class SanfiMeetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanfiMeetingApplication.class, args);
    }

}
