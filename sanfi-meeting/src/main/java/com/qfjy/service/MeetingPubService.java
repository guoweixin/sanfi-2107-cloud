package com.qfjy.service;

import com.qfjy.entity.po.MeetingPub;
import org.apache.ibatis.annotations.Select;

public interface MeetingPubService {

    /**
     * TODO 根据会议编号查询会议详情
     * @param pcode 会议编号
     * @return
     */
    MeetingPub selectMeetingPubByPcode(String pcode);
}
