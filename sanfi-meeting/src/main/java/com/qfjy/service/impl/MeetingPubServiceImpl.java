package com.qfjy.service.impl;

import com.qfjy.entity.po.MeetingPub;
import com.qfjy.mapper.MeetingPubMapper;
import com.qfjy.service.MeetingPubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MeetingPubServiceImpl
 * @Description TODO
 * @Author guoweixin
 * @Date 2022/5/31
 * @Version 1.0
 */
@Service
@Slf4j
public class MeetingPubServiceImpl implements MeetingPubService {

    @Autowired
    private MeetingPubMapper meetingPubMapper;

    /**
     * TODO 根据会议编号查询会议详情
     *
     * @param pcode 会议编号
     * @return
     */
    @Override
    public MeetingPub selectMeetingPubByPcode(String pcode) {
        return meetingPubMapper.selectMeetingPubByPcode(pcode);
    }
}
