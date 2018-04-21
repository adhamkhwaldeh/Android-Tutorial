package com.son.jawad.ui_widgets.Activities.StorageActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.tutoriallibrary.ImageCashFile.util.FileManager;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-09-17.
 */

public class StorageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storage_layout);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.filenamaherbtn:
                startActivity(new Intent(StorageActivity.this, FileManagerActivity.class));
                break;
            case R.id.sharedpreferancebtn:
                startActivity(new Intent(StorageActivity.this, SharedPreferanceActivity.class));
                break;
            case R.id.sharedpreferancSettingebtn:
                startActivity(new Intent(StorageActivity.this, SharedPreferanceSettingActivity.class));
                break;
            case R.id.sqllitebtn:
                startActivity(new Intent(StorageActivity.this, AndroidSQLiteTutorialActivity.class));
                break;
        }
    }
}
