package com.son.jawad.tutoriallibrary.Providers.ApplicationsProvider;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;

import java.util.List;
import java.util.Vector;

public class getApplications extends AsyncTask<Void, Void, List<AppInfo>> {

    public Context context;
    public ApplicationCallBackListener applicationCallBackListener;

    public getApplications(Context context, ApplicationCallBackListener applicationCallBackListener) {
        this.context = context;
        this.applicationCallBackListener = applicationCallBackListener;
    }

    public void setApplicationCallBackListener(ApplicationCallBackListener applicationCallBackListener) {
        this.applicationCallBackListener = applicationCallBackListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        applicationCallBackListener.onPreexcute();
    }

    @Override
    protected List<AppInfo> doInBackground(Void... voids) {
        List<AppInfo> appList = new Vector<>();
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packages = packageManager.getInstalledPackages(PackageManager.GET_META_DATA);
        for (PackageInfo packageInfo : packages) {
            if (!(packageManager.getApplicationLabel(packageInfo.applicationInfo).equals("") || packageInfo.packageName.equals(""))) {
                //if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0)
                AppInfo tempApp = new AppInfo(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString(), packageInfo.packageName, packageInfo.versionName, packageInfo.applicationInfo.sourceDir, packageInfo.applicationInfo.dataDir, packageManager.getApplicationIcon(packageInfo.applicationInfo), false);
                appList.add(tempApp);
            }
        }
        return appList;
    }

    @Override
    protected void onPostExecute(List<AppInfo> appList) {
        super.onPostExecute(appList);
        if (applicationCallBackListener != null)
            applicationCallBackListener.onPostexcute(appList);

    }


}
