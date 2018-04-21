package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.FetchData;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.Pojo;

import java.util.List;

/**
 * Created by Adhamkh on 2017-09-07.
 */

public interface GeneralProviderCallBackListener {
    void PreFetch();

    void PostFetch(List<Pojo> pojoList);
}
