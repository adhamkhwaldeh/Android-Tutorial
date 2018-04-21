package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.loader;

import android.content.Context;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.dataprovider.PhoneProvider;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.PhonePojo;

import java.util.ArrayList;

public class LoadPhonePojos extends LoadPojos<PhonePojo> {

    public LoadPhonePojos(Context context) {
        super(context, PhoneProvider.PHONE_SCHEME);
    }

    @Override
    protected ArrayList<PhonePojo> doInBackground(Void... params) {
        return null;
    }
}
