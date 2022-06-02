package com.qfjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //Eureka 服务端
public class SanfiEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanfiEurekaApplication.class, args);
    }

}
