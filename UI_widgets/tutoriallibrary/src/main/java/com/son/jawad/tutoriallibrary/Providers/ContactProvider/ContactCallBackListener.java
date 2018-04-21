package com.son.jawad.tutoriallibrary.Providers.ContactProvider;

import java.util.List;

/**
 * Created by Adhamkh on 2017-09-05.
 */

public interface ContactCallBackListener {
    void onPreexcute();

    void onPostexcute(List<Contact> applist);
}
