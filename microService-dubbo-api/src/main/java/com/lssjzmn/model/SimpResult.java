package com.lssjzmn.model;

import java.io.Serializable;

public class SimpResult implements Serializable {

    private int code;

    private String status;

    private String body;

    public SimpResult success() {
        this.code = 0;
        this.status = "SUCCESS";
        this.body = "";
        return this;
    }

    public SimpResult failer(int code, String body) {
        this.code = code;
        this.status = "FAILER";
        this.body = body;
        return this;
    }

    public SimpResult result(int code, String status, String body) {
        this.code = code;
        this.status = status;
        this.body = body;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "SimpResult{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
