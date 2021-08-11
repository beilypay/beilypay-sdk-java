package com.beilypay.pay.sdk.java.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    /**
     * 响应码  200 ok   500 error  ...
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;


    /**
     * 数据
     */
    private T data;



    /**
     * 正常返回
     * @param data
     * @return
     */
    public static <T> Response ok(T data){
        return Response.builder().code(200).msg("SUCC").data(data).build();
    }


    public static Response ok(Integer code, String message) {
        return Response.builder().code(code).msg(message).build();
    }



    /**
     * 服务异常
     * @return
     */
    public static Response error(){
        return Response.builder().code(500).msg("服务异常，请重试").build();
    }


    /**
     * 服务异常
     * @return
     */
    public static Response error(String msg){
        return Response.builder().code(500).msg(msg).build();
    }
}
