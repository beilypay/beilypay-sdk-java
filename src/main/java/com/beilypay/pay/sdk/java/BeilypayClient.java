package com.beilypay.pay.sdk.java;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.beilypay.pay.sdk.java.constant.ApiConstant;
import com.beilypay.pay.sdk.java.exception.BeilypayException;
import com.beilypay.pay.sdk.java.request.PaymentQueryReq;
import com.beilypay.pay.sdk.java.request.PaymentReq;
import com.beilypay.pay.sdk.java.request.TransQueryReq;
import com.beilypay.pay.sdk.java.request.TransReq;
import com.beilypay.pay.sdk.java.response.*;
import com.beilypay.pay.sdk.java.util.HttpClient;
import com.beilypay.pay.sdk.java.util.SignUtil;

public class BeilypayClient {


    private Long appId;

    private Integer merchantId;

    private String appSecret;

    /**
     * api域名
     *
     * 正式环境 http://service.beilypay.com
     * 测试环境 http://dev.beilypay.com
     */
    private String domain;


    public BeilypayClient(Long appId, Integer merchantId, String appSecret, String domain) {
        this.appId = appId;
        this.merchantId = merchantId;
        this.appSecret = appSecret;
        this.domain = domain;
    }


    /**
     * 创建代收交易
     * @param paymentReq
     * @return
     */
    public Response<PayVO> createPayment(PaymentReq paymentReq) throws BeilypayException {
        String url = domain + ApiConstant.CREATE_PAYMENT_URL;
        paymentReq.setAppId(appId);
        paymentReq.setMerchantId(merchantId);
        String signature = SignUtil.generateSignature(paymentReq, appSecret);
        paymentReq.setSign(signature);
        String rsp = HttpClient.doPost(url, JSON.toJSONString(paymentReq));
        Response<PayVO> response = JSON.parseObject(rsp, new TypeReference<Response<PayVO>>() {});
        SignUtil.verify(response,appSecret);
        return response;
    }


    /**
     * 代收交易查询
     * @param queryReq
     * @return
     */
    public Response<PaymentOrderVO> queryPayment(PaymentQueryReq queryReq) throws BeilypayException {
        String url = domain + ApiConstant.PAYMENT_QUERY_URL;
        queryReq.setAppId(appId);
        queryReq.setMerchantId(merchantId);
        String signature = SignUtil.generateSignature(queryReq, appSecret);
        queryReq.setSign(signature);
        String rsp = HttpClient.doPost(url, JSON.toJSONString(queryReq));
        Response<PaymentOrderVO> response = JSON.parseObject(rsp, new TypeReference<Response<PaymentOrderVO>>() {});
        SignUtil.verify(response,appSecret);
        return response;
    }




    /**
     * 创建代付交易
     * @param transReq
     * @return
     */
    public Response<TransVO> createTrans(TransReq transReq) throws BeilypayException {
        String url = domain + ApiConstant.CREATE_TRANS_URL;
        transReq.setAppId(appId);
        transReq.setMerchantId(merchantId);
        String signature = SignUtil.generateSignature(transReq, appSecret);
        transReq.setSign(signature);
        String rsp = HttpClient.doPost(url, JSON.toJSONString(transReq));
        Response<TransVO> response = JSON.parseObject(rsp, new TypeReference<Response<TransVO>>() {});
        SignUtil.verify(response,appSecret);
        return response;

    }


    /**
     * 代付交易查询
     * @param queryReq
     * @return
     */
    public Response<TransOrderVO> queryTrans(TransQueryReq queryReq) throws BeilypayException {
        String url = domain + ApiConstant.TRANS_QUERY_URL;
        queryReq.setAppId(appId);
        queryReq.setMerchantId(merchantId);
        String signature = SignUtil.generateSignature(queryReq, appSecret);
        queryReq.setSign(signature);
        String rsp = HttpClient.doPost(url, JSON.toJSONString(queryReq));
        Response<TransOrderVO> response = JSON.parseObject(rsp, new TypeReference<Response<TransOrderVO>>() {});
        SignUtil.verify(response,appSecret);
        return response;
    }

}
