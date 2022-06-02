package com.qfjy.client;

import com.qfjy.client.impl.VideoInfoFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
用于通知Feign组件对该接口进行代理(不需要编写接口实现)，

name属性  指定FeignClient名称。指定我们要调用哪个服务。name属性会作为微服务的名称，用于服务发现。使用者可直接通过@Autowired注入。

path属性 定义当前FeignClient的统一前缀

fallback属性 定义容错的处理类，当调用远程接口失败或超时时，
 会调用对应接口的容错逻辑。fallback指定的类必须实现@FeignClient标记的接口
 */
@FeignClient(name = "SANFI-VIDEO",path = "videoInfo",fallback = VideoInfoFallback.class)
public interface VideoInfoFeignClient {

    @GetMapping("video")
    @ResponseBody
    public String selectVideoInfoByPcode(@RequestParam("pcode") String pcode);


    @GetMapping("video1")
    @ResponseBody
    public String selectVideoInfoByPcode1(@RequestParam("pcode") String pcode);

    //视频微服务（进程和进程间通信）HTTP方式（Spring RestTemplate)
//            String url="http://localhost:8085/videoInfo/video?pcode="+meetingPub.getPcode();
//            String result=restTemplate.getForObject(url,String.class);

    // ribbon+RestTemplate    Eureka 服务器 服务实例名称=ip:port
//            String url="http://SANFI-VIDEO/videoInfo/video?pcode="+meetingPub.getPcode();
//            String result=restTemplate.getForObject(url,String.class);
//            meetingPub.setRemark(result);

    //Feign 服务间通信
}
