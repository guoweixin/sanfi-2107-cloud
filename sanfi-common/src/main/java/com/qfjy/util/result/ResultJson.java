package com.qfjy.util.result;

import lombok.Data;

/**
 * @ClassName ResultJson
 * @Description TODO
 * @Author guoweixin
 * @Version 1.0
 */
@Data
public class ResultJson<T> {

    /*响应码*/
    private String code;
    /*消息提示内容文件*/
    private String msg;
    /*返回指定对象*/
    private T data;

    /** 成功的方法*/
    public ResultJson(T t) {
        this.setCode(ResultCode.SUCCESS.getCode());
        this.setMsg(ResultCode.SUCCESS.getMsg());
        this.setData(t);
    }
    /**已有的ResultCode 进行返回*/
    public ResultJson(T t,ResultCode code){
        this.setCode(code.getCode());
        this.setMsg(code.getMsg());
        this.setData(t);
    }
    /** 完全自定义返回 */
    public ResultJson(T t,String code,String message){
        this.setCode(code);
        this.setMsg(message);
        this.setData(t);
    }
}