package com.qfjy.controller;

import com.qfjy.serivce.VideoInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName VideoInfoController
 * @Description TODO
 * @Author guoweixin
 * @Date 2022/5/31
 * @Version 1.0
 */
@Controller
@Slf4j
@RequestMapping("videoInfo")
public class VideoInfoController {

    @Autowired
    private VideoInfoService videoInfoService;

    @Value("${server.port}")
    private int port;

    /**
     * 根据会议编号 查找视频召开相关详情
     * videoInfo/video?pcode=1111
     */
    @GetMapping("video")
    @ResponseBody
    public String selectVideoInfoByPcode(@RequestParam("pcode") String pcode){
        log.info("视频微服务--》查询视频召开详情{}",pcode);


        return  videoInfoService.selectVideoInfoByPcode(pcode)+"\t"+port;
    }

    @GetMapping("video1")
    @ResponseBody
    public String selectVideoInfoByPcode1(@RequestParam("pcode") String pcode){
        log.info("视频微服务--》查询视频召开详情{}",pcode);

        return  "aaaa123"+"\t"+port;
    }
}
