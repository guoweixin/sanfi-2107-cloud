package com.qfjy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplateConfig
 * @Description TODO
 * @Author guoweixin
 * @Date 2022/6/1
 * @Version 1.0
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
