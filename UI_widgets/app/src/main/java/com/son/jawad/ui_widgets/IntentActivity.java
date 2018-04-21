package com.son.jawad.ui_widgets;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by Adhamkh on 2017-08-21
 */

public class IntentActivity extends AppCompatActivity {

    public Spinner spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_layout);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.intents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onClick(View view) {
        int position = spinner.getSelectedItemPosition();
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.vogella.com"));
                break;
            case 1:
                intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:(+49)12345789"));
                break;
            case 2:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:50.123,7.1434?z=19"));
                break;
            case 3:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=query"));
                break;
            case 4:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                break;
            case 5:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://contacts/people/"));
                break;
            case 6:
                intent = new Intent(Intent.ACTION_EDIT,
                        Uri.parse("content://contacts/people/1"));
                break;

        }
        if (intent != null) {
            startActivity(intent);
        }
    }


    //Intent Service

    public static boolean isIntentAvailable(Context ctx, Intent intent) {
        final PackageManager mgr = ctx.getPackageManager();
        List<ResolveInfo> list =
                mgr.queryIntentActivities(intent,
                        PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    public void onclickbtn(View view) {
        switch (view.getId()) {
            case R.id.intentstartactivity:
                startActivity(new Intent(IntentActivity.this, MainActivity.class));
                break;
            case R.id.intentSharedata:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, "News for you!");
                startActivity(intent);
                break;
            case R.id.intentopenwebsite:
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com"));
                startActivity(i);
                break;
        }
    }

}
