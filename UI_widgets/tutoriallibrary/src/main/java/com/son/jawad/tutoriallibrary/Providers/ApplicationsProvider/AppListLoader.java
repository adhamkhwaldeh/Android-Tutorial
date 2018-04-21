package com.son.jawad.tutoriallibrary.Providers.ApplicationsProvider;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by vishal on 23/2/17.
 * <p>
 * Class loads all the packages installed
 */

public class AppListLoader extends AsyncTaskLoader<List<AppInfo>> {

    private PackageManager packageManager;
    private Context context;
    private List<AppInfo> mApps;

    public AppListLoader(Context context) {
        super(context);
        this.context = context;

        packageManager = getContext().getPackageManager();
    }

    @Override
    public List<AppInfo> loadInBackground() {
        List<PackageInfo> apps = packageManager.getInstalledPackages(PackageManager.GET_META_DATA);

        if (apps == null)
            apps = new ArrayList<>();

        mApps = new Vector<>();
        for (PackageInfo packageInfo : apps) {
            if (!(packageManager.getApplicationLabel(packageInfo.applicationInfo).equals("") || packageInfo.packageName.equals(""))) {
                //if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0)
                AppInfo tempApp = new AppInfo(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString()
                        , packageInfo.packageName, packageInfo.versionName, packageInfo.applicationInfo.sourceDir,
                        packageInfo.applicationInfo.dataDir,
                        packageManager.getApplicationIcon(packageInfo.applicationInfo), false);
                mApps.add(tempApp);
            }
        }
        return mApps;
    }

    @Override
    public void deliverResult(List<AppInfo> data) {
        if (isReset()) {
            if (data != null)
                onReleaseResources(data);//TODO onReleaseResources() is empty
        }

        // preserving old data for it to be closed
        List<AppInfo> oldData = mApps;
        mApps = data;
        if (isStarted()) {
            // loader has been started, if we have data, return immediately
            super.deliverResult(mApps);
        }
        // releasing older resources as we don't need them now
        if (oldData != null) {
            onReleaseResources(oldData);//TODO onReleaseResources() is empty
        }
    }

    @Override
    protected void onStartLoading() {

        if (mApps != null) {
            // we already have the results, load immediately
            deliverResult(mApps);
        }
        forceLoad();
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    public void onCanceled(List<AppInfo> data) {
        super.onCanceled(data);

        onReleaseResources(data);//TODO onReleaseResources() is empty
    }

    @Override
    protected void onReset() {
        super.onReset();

        onStopLoading();

        // we're free to clear resources
        if (mApps != null) {
            onReleaseResources(mApps);//TODO onReleaseResources() is empty
            mApps = null;
        }
    }

    //TODO do something
    private void onReleaseResources(List<AppInfo> appInfoList) {

    }
}
