package com.beilypay.pay.sdk.java.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 代收查询结果
 */
@Data
public class PaymentOrderVO implements Serializable {


    /**
     * 代收单状态 0 代收创建失败  1等待回调；2成功；3失败
     */
    private Integer status;

    /**
     *
     */
    private String outOrderNo;

    /**
     * 交易号
     */
    private String orderNo;


    /**
     * 代收单金额 单位 分
     */
    private Integer payAmount;

    /**
     * 实付金额 单位 分
     */
    private Integer paid;

    /**
     * 交易完成时间 yyyy-MM-dd HH:mm:ss
     */
    private String transTime;

    private String sign;

}
