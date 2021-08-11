package com.beilypay.pay.sdk.java.request;

import lombok.Data;
import java.io.Serializable;


/**
 * 代付交易查询
 */
@Data
public class TransQueryReq implements Serializable {

    /**
     * 商户id
     */
    private Integer merchantId;

    /**
     * 应用id
     */
    private Long appId;

    private String orderNo;

    /**
     * 签名
     */
    private String sign;
}
