package com.son.jawad.ui_widgets.Networks;

/**
 * Created by Adhamkh on 2017-08-31.
 */

public enum ResponseState {
    RESPONSE_SUCCESS(1), RESPONSE_ERRORCONNECTION(2), RESPONSE_SERVERERROR(3), RESPONSE_PARSEERROR(4);
    int val;

    ResponseState(int val) {
        this.val = val;
    }
}
