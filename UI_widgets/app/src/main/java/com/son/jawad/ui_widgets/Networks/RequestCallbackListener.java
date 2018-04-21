package com.son.jawad.ui_widgets.Networks;

/**
 * Created by Adhamkh on 2017-08-31.
 */

public interface RequestCallbackListener<T> {
    void onPreRequest();
    void onPostRequest(UrlResponse<T> urlResponse);
}
