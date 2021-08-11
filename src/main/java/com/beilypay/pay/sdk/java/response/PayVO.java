package com.beilypay.pay.sdk.java.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 代收下单返回
 */
@Data
public class PayVO implements Serializable {

    /**
     * 交易号
     */
    private String orderNo;


    /**
     * 平台单号
     */
    private String outOrderNo;


    /**
     * 支付金额
     */
    private Integer payAmount;


    /**
     * 支付链接
     */
    private String payUrl;


    /**
     * 签名
     */
    private String sign;
}
