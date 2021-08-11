package com.beilypay.pay.sdk.java.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 代收下单参数
 */
@Data
public class PaymentReq implements Serializable {


    /**
     * 商户id
     */
    private Integer merchantId;


    /**
     * 应用id
     */
    private Long appId;


    /**
     * 商户单号
     */
    private String outOrderNo;

    /**
     * 支付金额 整数 单位分 代收金额至少为1 INR
     */
    private Integer payAmount;


    /**
     * 商户用户标识
     */
    private String userId;


    /**
     * userName
     */
    private String userName;


    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;


    /**
     * 前端支付完成回调页面
     */
    private String frontCallback;

    /**
     * 通知回调地址
     */
    private String notifyUrl;

    /**
     * 请求签名
     */
    private String sign;

}
