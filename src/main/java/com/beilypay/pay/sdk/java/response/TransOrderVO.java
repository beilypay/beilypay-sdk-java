package com.beilypay.pay.sdk.java.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 代收单详情查询
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransOrderVO implements Serializable {

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

}
