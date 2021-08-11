package com.beilypay.pay.sdk.java.notify;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 代付异步通知
 */
@Data
public class TransNotify implements Serializable {


    /**
     * 商户id
     */
    private Integer merchantId;

    /**
     * 应用id
     */
    private Long appId;

    private String orderNo;

    private String outOrderNo;



    /**
     * 代付金额
     */
    private Integer payAmount;


    /**
     * 代付单状态 1等待回调；2成功；3失败；
     */
    private Integer status;


    private String sign;


    private LocalDateTime payTime;
}
