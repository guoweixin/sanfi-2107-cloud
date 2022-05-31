package com.qfjy.controller;

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
            return new ResultJson<>(meetingPub, ResultCode.SUCCESS);
        }
        return new ResultJson<>(null,ResultCode.NOT_DATA);
    }
}
