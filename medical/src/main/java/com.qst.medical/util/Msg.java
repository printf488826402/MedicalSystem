package com.qst.medical.util;

import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.HashMap;
import java.util.Map;


public class Msg {
    /*状态码*/
    private Integer code;
    /*响应消息*/
    private String message;
    /*响应是否成功标志*/
    private boolean success;
    /*响应的数据*/
    private Map<String,Object> data = new HashMap<>();
    //get/set方法以及其他方法略
}
public static Msg fail() {
    Msg msg = new Msg();
    msg.setCode(10000);
    msg.setMessage("响应失败");
    msg.setSuccess(false);
    return msg;
}
public Msg data(String key, Object value) {
    this.data.put(key,value);
    return this;
}
public Msg code(Integer code) {
    this.setCode(code);
    return this;
}
public Msg mess(String str) {
    this.setMessage(str);
    return this;
}