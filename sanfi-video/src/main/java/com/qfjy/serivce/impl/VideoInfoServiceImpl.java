package com.qfjy.serivce.impl;

import com.qfjy.serivce.VideoInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName VideoInfoServiceImpl
 * @Description TODO
 * @Author guoweixin
 * @Date 2022/5/31
 * @Version 1.0
 */
@Service
@Slf4j
public class VideoInfoServiceImpl implements VideoInfoService {
    /**
     * 根据会议编号，查询得到视频召开详情
     *
     * @param pcode
     */
    @Override
    public String selectVideoInfoByPcode(String pcode) {
        return "视频会议召开结果：参会人员18人，召开时间是59分钟，网络顺畅,-->"+pcode;
    }
}
