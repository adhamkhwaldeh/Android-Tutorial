package com.son.jawad.tutoriallibrary.Providers.ApplicationsProvider;

import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * Created by Adhamkh on 2017-09-04.
 */

public class UtilsApp {

    public static Intent getShareIntent(File file) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        intent.setType("application/vnd.android.package-archive");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

}
