package com.qfjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //声明ZUUL代理
@EnableEurekaClient
public class SanfiZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanfiZuulApplication.class, args);
    }

}
