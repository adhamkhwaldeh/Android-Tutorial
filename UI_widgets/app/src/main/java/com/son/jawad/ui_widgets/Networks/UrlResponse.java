package com.son.jawad.ui_widgets.Networks;

import android.support.annotation.Nullable;

/**
 * Created by Adhamkh on 2017-08-31.
 */

public class UrlResponse<T> {
    public T ResponseObject;
    public ResponseMessage responseState;

    public UrlResponse() {
    }

    public UrlResponse(@Nullable T responseObject, ResponseMessage responseState) {
        ResponseObject = responseObject;
        this.responseState = responseState;
    }

    public T getResponseObject() {
        return ResponseObject;
    }

    public void setResponseObject(T responseObject) {
        ResponseObject = responseObject;
    }

    public ResponseMessage getResponseState() {
        return responseState;
    }

    public void setResponseState(ResponseMessage responseState) {
        this.responseState = responseState;
    }

}
