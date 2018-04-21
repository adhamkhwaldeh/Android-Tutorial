package com.son.jawad.ui_widgets.Networks;

/**
 * Created by Adhamkh on 2017-08-31.
 */

public class ResponseMessage {
    public String Message;
    public ResponseState responseState;

    public ResponseMessage(ResponseState responseState) {
        this.responseState = responseState;
    }

    public ResponseMessage(String message, ResponseState responseState) {
        Message = message;
        this.responseState = responseState;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public ResponseState getResponseState() {
        return responseState;
    }

    public void setResponseState(ResponseState responseState) {
        this.responseState = responseState;
    }
}
