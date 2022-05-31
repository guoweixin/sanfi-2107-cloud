package com.qfjy.serivce;

public interface VideoInfoService {

    /**
     * 根据会议编号，查询得到视频召开详情
     */
    public String selectVideoInfoByPcode(String pcode);
}
