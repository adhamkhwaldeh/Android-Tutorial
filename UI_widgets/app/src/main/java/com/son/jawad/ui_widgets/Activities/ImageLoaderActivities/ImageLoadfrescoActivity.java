package com.son.jawad.ui_widgets.Activities.ImageLoaderActivities;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-09-03.
 */

public class ImageLoadfrescoActivity extends AppCompatActivity {
    SimpleDraweeView imageView1, imageView2, imageView3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageloadingfresco_layout);
        imageView1 = (SimpleDraweeView) findViewById(R.id.imageView1);
        imageView2 = (SimpleDraweeView) findViewById(R.id.imageView2);
        imageView3 = (SimpleDraweeView) findViewById(R.id.imageView3);

        Uri uri = Uri.parse("https://source.unsplash.com/random");
        imageView1.setImageURI(uri);
        imageView2.setImageURI(uri);
        imageView3.setImageURI(uri);

    }
}
