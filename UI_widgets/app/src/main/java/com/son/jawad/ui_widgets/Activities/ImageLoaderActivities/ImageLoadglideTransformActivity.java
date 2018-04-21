package com.son.jawad.ui_widgets.Activities.ImageLoaderActivities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.son.jawad.ui_widgets.R;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Adhamkh on 2017-09-03.
 */

public class ImageLoadglideTransformActivity extends AppCompatActivity {
    public ImageView imageView1, imageView2, imageView3, imageView4;
    public Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageloadglidetransform_layout);
        context = this;
        imageView1 = (ImageView) findViewById(R.id.ImageViewglide1);
        imageView2 = (ImageView) findViewById(R.id.ImageViewglide2);
        imageView3 = (ImageView) findViewById(R.id.ImageViewglide3);
        imageView4 = (ImageView) findViewById(R.id.ImageViewglide4);
        int radius = 30; // corner radius, higher value = more rounded
        int margin = 10; // crop margin, set to 0 for corners with no crop

        Glide.with(this)
                .load("https://source.unsplash.com/random")
                .bitmapTransform(new RoundedCornersTransformation(context, radius, margin))
                .into(imageView1);

        Glide.with(this)
                .load("https://source.unsplash.com/random")
                .bitmapTransform(new CropCircleTransformation(context))
                .into(imageView2);

        Glide.with(this)
                .load("https://source.unsplash.com/random")
                .bitmapTransform(new BlurTransformation(context))
                .into(imageView3);

        Glide.with(this)
                .load("https://source.unsplash.com/random")
                .bitmapTransform(new BlurTransformation(context, 25), new CropCircleTransformation(context))
                .into(imageView4);
    }

}
