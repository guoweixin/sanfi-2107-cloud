package com.qfjy.mapper;

import com.qfjy.entity.po.MeetingPub;
import org.apache.ibatis.annotations.Select;

public interface MeetingPubMapper {
    int deleteByPrimaryKey(String id);

    int insert(MeetingPub record);

    int insertSelective(MeetingPub record);

    MeetingPub selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MeetingPub record);

    int updateByPrimaryKey(MeetingPub record);

    /** 根据会议编号查询会议详情 */
    @Select("select * from meetingpub where pcode=#{pcode} ")
    MeetingPub selectMeetingPubByPcode(String pcode);
}