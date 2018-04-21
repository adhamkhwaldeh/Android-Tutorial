package com.son.jawad.ui_widgets.Models;

/**
 * Created by Adhamkh on 2017-09-08.
 */

public class Response {
    public Boolean IsOk;
    public Message Message;

    public Boolean getOk() {
        return IsOk;
    }

    public void setOk(Boolean ok) {
        IsOk = ok;
    }

    public com.son.jawad.ui_widgets.Models.Message getMessage() {
        return Message;
    }

    public void setMessage(com.son.jawad.ui_widgets.Models.Message message) {
        Message = message;
    }
}
