package com.son.jawad.ui_widgets.Activities.ServicesActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.son.jawad.ui_widgets.Activities.ServicesActivities.Services.DownloadResultReceiver;
import com.son.jawad.ui_widgets.Activities.ServicesActivities.Services.MyIntentService;
import com.son.jawad.ui_widgets.R;

public class IntentServiceActivity extends Activity implements DownloadResultReceiver.Receiver {

    private ListView listView = null;

    private ArrayAdapter arrayAdapter = null;

    private DownloadResultReceiver mReceiver;

    final String url = "http://javatechig.com/api/get_category_posts/?dev=1&slug=android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Allow activity to show indeterminate progressbar */
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        /* Set activity layout */
        setContentView(R.layout.intentservice_layout);

        /* Initialize listView */
        listView = (ListView) findViewById(R.id.listView);

        /* Starting Download Service */
        mReceiver = new DownloadResultReceiver(new Handler());
        mReceiver.setReceiver(this);
        Intent intent = new Intent(Intent.ACTION_SYNC, null, this, MyIntentService.class);

        /* Send optional extras to Download IntentService */
        intent.putExtra("url", url);
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("requestId", 101);

        startService(intent);
    }


    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        switch (resultCode) {
            case MyIntentService.STATUS_RUNNING:

                setProgressBarIndeterminateVisibility(true);
                break;
            case MyIntentService.STATUS_FINISHED:
                /* Hide progress & extract result from bundle */
                setProgressBarIndeterminateVisibility(false);

                String[] results = resultData.getStringArray("result");

                /* Update ListView with result */
                arrayAdapter = new ArrayAdapter(IntentServiceActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, results);
                listView.setAdapter(arrayAdapter);

                break;
            case MyIntentService.STATUS_ERROR:
                /* Handle the error */
                String error = resultData.getString(Intent.EXTRA_TEXT);
                Toast.makeText(this, error, Toast.LENGTH_LONG).show();
                break;
        }
    }

}