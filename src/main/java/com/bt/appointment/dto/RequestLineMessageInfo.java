package com.bt.appointment.dto;

import java.io.Serializable;

public class RequestLineMessageInfo implements Serializable {

    private MessageInfo messageInfo;

    public RequestLineMessageInfo() {
    }

    public MessageInfo getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(MessageInfo messageInfo) {
        this.messageInfo = messageInfo;
    }

    @Override
    public String toString() {
        return "RequestLineMessageInfo [messageInfo=" + messageInfo + "]";
    }

}
