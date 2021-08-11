package com.beilypay.pay.sdk.java.util;

import com.beilypay.pay.sdk.java.exception.BeilypayException;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpClient {

    public static final String CHARSET_UTF8     = "UTF-8";
    private static final String METHOD_POST     = "POST";
    private static final String METHOD_GET      = "GET";
    private static int  connectTimeout = 3000;
    private static int  readTimeout    = 15000;

    /**
     * 执行HTTP POST请求。
     *
     * @param url            请求地址
     * @param json           请求体
     * @return 响应字符串
     * @throws IOException
     */
    public static String doPost(String url, String json, Map<String, String> headers)  throws IOException {
        HttpURLConnection conn = null;
        OutputStream out = null;
        String rsp = null;
        try {
            try {
                conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setConnectTimeout(connectTimeout);
                conn.setReadTimeout(readTimeout);
                conn.setRequestMethod(METHOD_POST);
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setRequestProperty("Accept", "*/*");
                conn.setRequestProperty("Content-Type",  "application/json;charset=" + CHARSET_UTF8);
                if (headers != null) {
                    for (Map.Entry<String, String> header : headers.entrySet()) {
                        conn.setRequestProperty(header.getKey(), header.getValue());
                    }
                }
            } catch (IOException e) {
                throw e;
            }
            try {
                out = conn.getOutputStream();
                out.write(json.getBytes());
                rsp = getResponseAsString(conn);
            } catch (IOException e) {
                throw e;
            }

        } finally {
            if (out != null) {
                out.close();
            }
            if (conn != null) {
                conn.disconnect();

            }
        }

        return rsp;
    }

    public static String doPost(String url, String json) throws BeilypayException {
        try {
            return doPost(url,json,null);
        } catch (IOException e) {
            throw new BeilypayException(e);
        }
    }

    protected static String getResponseAsString(HttpURLConnection conn) throws IOException {
        InputStream es = conn.getErrorStream();
        if (es == null) {
            return getStreamAsString(conn.getInputStream(), CHARSET_UTF8);
        } else {
            String msg = getStreamAsString(es, CHARSET_UTF8);
            if (StringUtils.isEmpty(msg)) {
                throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
            } else {
                throw new IOException(msg);
            }
        }
    }

    private static String getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset));
            StringWriter writer = new StringWriter();

            char[] chars = new char[256];
            int count = 0;
            while ((count = reader.read(chars)) > 0) {
                writer.write(chars, 0, count);
            }

            return writer.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public static void setConnectTimeout(int connectTimeout) {
        HttpClient.connectTimeout = connectTimeout;
    }

    public static void setReadTimeout(int readTimeout) {
        HttpClient.readTimeout = readTimeout;
    }
}
