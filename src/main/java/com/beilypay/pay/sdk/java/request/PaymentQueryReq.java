package com.beilypay.pay.sdk.java.request;

import lombok.Data;
import java.io.Serializable;

/**
 *代收单查询
 */
@Data
public class PaymentQueryReq implements Serializable {

    /**
     * 商户id
     */
    private Integer merchantId;

    /**
     * 应用id
     */
    private Long appId;


    /**
     * 交易号
     */
    private String orderNo;


    private String sign;



}
