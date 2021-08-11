package com.beilypay.pay.sdk.java.notify;

import lombok.Data;

import java.time.LocalDateTime;


/**
 * 回调处理结果VO
 */
@Data
public class PaymentNotify {

    /**
     * 平台单号
     */
    private String outOrderNo;


    /**
     * 交易流水号
     */
    private String orderNo;

    /**
     * 2：支付成功，3：支付失败
     */
    private Integer status;

    /**
     * 实付金额
     */
    private Integer paid;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;


    private String sign;

}
