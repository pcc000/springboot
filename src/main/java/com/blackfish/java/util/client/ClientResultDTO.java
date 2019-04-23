package com.blackfish.java.util.client;

import org.apache.http.StatusLine;

/**
 * 
 * Created by stefanxu on 2018/8/24.
 */

public class ClientResultDTO {

    /**
     * http 状态码
     */
    private StatusLine statusLine;

    /**
     * content
     */
    private String result;

    public StatusLine getStatusLine() {
        return statusLine;
    }

    public void setStatusLine(StatusLine statusLine) {
        this.statusLine = statusLine;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
