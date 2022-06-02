package com.qfjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //Eureka客户端
public class SanfiVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanfiVideoApplication.class, args);
    }

}
