package com.qfjy.client.impl;

import com.qfjy.client.VideoInfoFeignClient;
import org.springframework.stereotype.Component;

/**
 * @ClassName VideoInfoFallback
 * @Description TODO
 * @Author guoweixin
 * @Date 2022/6/2
 * @Version 1.0
 */
@Component
public class VideoInfoFallback implements VideoInfoFeignClient {
    @Override
    public String selectVideoInfoByPcode(String pcode) {
        return "视频微服务开小差了.."+pcode;
    }

    @Override
    public String selectVideoInfoByPcode1(String pcode) {
        return "selectVideoInfoByPcode1视频微服务开小差了.."+pcode;
    }
}
