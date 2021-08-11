# beilypay-sdk-java

# SDK使用示例
联系开发获取SDK
```java
public static void main(String[] args) throws Exception{

        BeilypayClient client = new BeilypayClient(appId,
                merchantId,
                key,
                domain);


        String no = "210804586153439232";
        PaymentReq req = new PaymentReq();
        req.setEmail("xxxxx@gmail.com");
        req.setFrontCallback("http://www.google.com");
        req.setMobile("8955080572");
        req.setNotifyUrl("http://dev.beilypay.com/notify/payment/grepay");
        req.setOutOrderNo(no);
        req.setPayAmount(500);
        req.setUserId("12345");
        req.setUserName("DougLea");
        Response<PayVO> payment = client.createPayment(req);

    }
```
