package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.DataHandler;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.KissApplication;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.dataprovider.ShortcutsProvider;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.ShortcutsPojo;


public class UninstallShortcutHandler extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent data) {

        DataHandler dh = KissApplication.getDataHandler(context);
        ShortcutsProvider sp = dh.getShortcutsProvider();

        if (sp == null)
            return;

        String name = data.getStringExtra(Intent.EXTRA_SHORTCUT_NAME);
        Log.d("onReceive", "Uninstall shortcut " + name);

        ShortcutsPojo pojo = (ShortcutsPojo) sp.findByName(name);
        if (pojo == null) {
            Log.d("onReceive", "Shortcut " + name + " not found");
            return;
        }

        dh.removeShortcut(pojo);

    }

}
