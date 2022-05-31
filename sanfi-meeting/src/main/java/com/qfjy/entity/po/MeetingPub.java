package com.qfjy.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class MeetingPub implements Serializable {
    private String id;

    private String pcode;

    private String ptime;

    private Integer tid;

    private String ptitle;

    private String pzone;

    private String remark;

    private Integer uid;

    private Date createdate;

    private Short status;


}