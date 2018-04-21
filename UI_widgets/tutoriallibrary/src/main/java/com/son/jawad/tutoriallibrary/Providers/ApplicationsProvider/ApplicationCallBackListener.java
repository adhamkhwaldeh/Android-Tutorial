package com.son.jawad.tutoriallibrary.Providers.ApplicationsProvider;

import java.util.List;

/**
 * Created by Adhamkh on 2017-09-04.
 */

public interface ApplicationCallBackListener {
    void onPreexcute();

    void onPostexcute(List<AppInfo> applist);
}
