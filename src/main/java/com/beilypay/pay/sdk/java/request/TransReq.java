package com.beilypay.pay.sdk.java.request;

import lombok.Data;

import java.io.Serializable;


/**
 * 代付请求
 */
@Data
public class TransReq implements Serializable {

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
     * 代付金额 整数 单位分 至少为1 INR
     */
    private Integer payAmount;


    /**
     * 收款账户类型 Card: 代付到银行卡
     */
    private String accountType;


    /**
     * 对应的收款账户 银行卡号
     */
    private String account;


    /**
     * 账户类型为Card,分行的IFSC代码
     */
    private String ifsc;

    /**
     * 账户类型为Card,对应的银行编码
     */
    private String bankCode;


    /**
     * 账户持有者姓名
     */
    private String accountOwner;

    /**
     * 收款人手机号
     */
    private String mobile;

    /**
     * 收款人邮箱
     */
    private String email;


    /**
     * 收款人地址
     */
    private String address;


    /**
     * 通知回调地址
     */
    private String notifyUrl;

    /**
     * 签名
     */
    private String sign;


}
