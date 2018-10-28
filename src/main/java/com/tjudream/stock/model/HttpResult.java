package com.tjudream.stock.model;

import java.util.Map;

/**
 * Created by mengxiansen on 2018/10/27.
 */
public class HttpResult {
    private int httpCode;
    private String result;
    private Map<String,String> headers;

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
