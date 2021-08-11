package com.beilypay.pay.sdk.java.util;

import com.beilypay.pay.sdk.java.exception.BeilypayException;
import com.beilypay.pay.sdk.java.response.Response;
import org.apache.commons.beanutils.BeanUtils;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SignUtil {

    public static final String SIGN_FILED = "sign";

    /**
     * 签名生成方法
     * @param param
     * @param key
     * @param <T>
     * @return
     * @throws Exception
     */
    public static<T> String generateSignature(T param, String key) {

        try {
            Map<String, String> map = BeanUtils.describe(param);
            Set<String> keySet = map.keySet();
            String[] keyArray = keySet.toArray(new String[keySet.size()]);
            Arrays.sort(keyArray);
            StringBuilder sb = new StringBuilder();
            for (String k : keyArray) {
                if (SIGN_FILED.equals(k)) {
                    continue;
                }
                if (map.get(k) != null) { // 参数值为空，则不参与签名
                    sb.append(k).append("=").append(map.get(k).trim()).append("&");
                }
            }
            sb.append("key=").append(key);
            return MD5(sb.toString());
        } catch (Exception e) {
            throw new IllegalArgumentException("数据签名失败");
        }
    }


    /**
     * 验证签名是否正确
     * @param param
     * @param key
     * @param <T>
     * @return
     */
    public static<T> boolean verify(T param, String key) {
        try {
            Map<String, String> map = BeanUtils.describe(param);
            String sign = map.get(SIGN_FILED);
            if(sign == null){
                return false;
            }
            String signature = generateSignature(param, key);
            return sign.equalsIgnoreCase(signature);
        } catch (Exception e) {
            throw new IllegalArgumentException("数据签名失败");
        }
    }


    /**
     * 验签，失败抛出异常
     * @param rsp
     * @param key
     * @param <T>
     * @throws BeilypayException
     */
    public static <T> void verify(Response<T> rsp, String key) throws BeilypayException {
        if(rsp.getCode() != 200 || rsp.getCode() == null){
            return;
        }
        boolean verify = verify(rsp.getData(), key);
        if(!verify){
            throw BeilypayException.signError();
        }
    }



    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String MD5(String data) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes(UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
}
