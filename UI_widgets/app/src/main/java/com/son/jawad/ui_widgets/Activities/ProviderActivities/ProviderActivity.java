package com.son.jawad.ui_widgets.Activities.ProviderActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-09-04.
 */

public class ProviderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.provider_layout);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ProviderAppId:
                startActivity(new Intent(ProviderActivity.this, ProviderApplicationActivity.class));
                break;
            case R.id.ProviderContactId:
                startActivity(new Intent(ProviderActivity.this, ProviderContactActivity.class));
                break;
            case R.id.ProviderGeneralId:
                startActivity(new Intent(ProviderActivity.this, ProviderGeneralSearchActivity.class));
                break;
        }
    }
}
