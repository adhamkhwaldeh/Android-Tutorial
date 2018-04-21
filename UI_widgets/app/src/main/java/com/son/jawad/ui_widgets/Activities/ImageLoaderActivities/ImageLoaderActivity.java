package com.son.jawad.ui_widgets.Activities.ImageLoaderActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-31.
 */

public class ImageLoaderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageloader_layout);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Imagecashfilerbtn:
                startActivity(new Intent(ImageLoaderActivity.this, ImageCashFileActivity.class));
                break;
            case R.id.Imagegliderbtn:
                startActivity(new Intent(ImageLoaderActivity.this, ImageLoadglideActivity.class));
                break;
            case R.id.Imagepicassoerbtn:
                startActivity(new Intent(ImageLoaderActivity.this, ImageLoadpicassoActivity.class));
                break;
            case R.id.Imagefrescorbtn:
                startActivity(new Intent(ImageLoaderActivity.this, ImageLoadfrescoActivity.class));
                break;
            case R.id.Imageglidetransformbtn:
                startActivity(new Intent(ImageLoaderActivity.this, ImageLoadglideTransformActivity.class));
                break;
            case R.id.ImagePicassotransformbtn:
                startActivity(new Intent(ImageLoaderActivity.this, ImageLoadpicassoTransformationActivity.class));
                break;
        }
    }

}
