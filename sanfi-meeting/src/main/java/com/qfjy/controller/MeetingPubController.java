package com.qfjy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qfjy.client.VideoInfoFeignClient;
import com.qfjy.entity.po.MeetingPub;
import com.qfjy.service.MeetingPubService;
import com.qfjy.util.result.ResultCode;
import com.qfjy.util.result.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName MeetingPubController
 * @Description TODO
 * @Author guoweixin
 * @Date 2022/5/31
 * @Version 1.0
 */
@Controller
@RequestMapping("meetingPub")
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class MeetingPubController {
    @Autowired
    private MeetingPubService meetingPubService;

    /**
     * 根据会议编号， 查询会议详细信息
     *  url: meetingPub/select?pcode=20210710001
     * @param pcode
     * @return
     */
    @GetMapping("select")
    @ResponseBody
    public Object selectMeetingPubByPcode(@RequestParam("pcode") String pcode){
       MeetingPub meetingPub= meetingPubService.selectMeetingPubByPcode(pcode);


        log.info("会议微服务--》根据会议编号，查询会议信息{}",pcode);
        if(meetingPub!=null){

            // ribbon+RestTemplate    Eureka 服务器 服务实例名称=ip:port
//            String url="http://SANFI-VIDEO/videoInfo/video?pcode="+meetingPub.getPcode();
//            String result=restTemplate.getForObject(url,String.class);
//            meetingPub.setRemark(result);


            //Feign 服务间通信
            String result = videoInfoFeignClient.selectVideoInfoByPcode(meetingPub.getPcode());
            meetingPub.setRemark(result);

          // String result1= videoInfoFeignClient.selectVideoInfoByPcode1("aaaa");



            return new ResultJson<>(meetingPub, ResultCode.SUCCESS);
        }
        return new ResultJson<>(null,ResultCode.NOT_DATA);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private VideoInfoFeignClient videoInfoFeignClient;


    @GetMapping("info")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "infoFallbackMethod")
    public String info(@RequestParam("id") String id){

        if(!"123".equals(id)){

                throw new RuntimeException("ID值不是123");

        }
        return "正常请求并响应成功--》"+id;
    }

    public String infoFallbackMethod(@RequestParam("id") String id){
        return "因值不是123，返回默认数据";
    }

    @GetMapping("info1")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "info1FallbackMethod")
    public String info1(@RequestParam("id") String id){

        if(!"123".equals(id)){

            throw new RuntimeException("info1 ID值不是123");

        }
        return " info1 正常请求并响应成功--》"+id;
    }

    public String info1FallbackMethod(@RequestParam("id") String id){
        return "info1 因值不是123，返回默认数据"+id;
    }


    @GetMapping("info2")
    @ResponseBody
    @HystrixCommand
    public String info2(@RequestParam("id") String id){

        if(!"123".equals(id)){

            throw new RuntimeException("info2 ID值不是123");

        }
        return " info2 正常请求并响应成功--》"+id;
    }

    @GetMapping("info3")
    @ResponseBody
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "6"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
    })
    public String info3(@RequestParam("id") String id){

        if(!"123".equals(id)){
            log.error("走这个方法啦--->");
            throw new RuntimeException("info3 ID值不是123");

        }
        return " info3 正常请求并响应成功--》"+id;
    }

    public String defaultFallback(){
        return "会议微服务开小差了...";
    }
}
