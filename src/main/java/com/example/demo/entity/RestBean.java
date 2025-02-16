package com.example.demo.entity;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

public record RestBean<T> (
        int code,
        T data,
        String message
)
{
    public static <T>RestBean<T> success(T data){
        return new RestBean<T>(200,data,"success");
    }
    public static <T>RestBean<T> success(){
        return success(null);
    }

    public static <T>RestBean<T> fail(int code , String message){
        return new RestBean<T>(code,null,message);
    }

    public String asJsonString(){
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }

}