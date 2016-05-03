package com.music.app.common.model;

/**
 * Created by Badri on 03/05/16.
 */
public class BaseStatus {

    private String status;

    private String baseMessage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return baseMessage;
    }

    public void setMessage(String baseMessage) {
        this.baseMessage = baseMessage;
    }
}
