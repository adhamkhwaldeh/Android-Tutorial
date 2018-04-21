package com.son.jawad.ui_widgets.Activities.ImageLoaderActivities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-09-03.
 */

public class ImageLoadglideActivity extends AppCompatActivity {
    public ImageView imageView1, imageView2, imageView3, imageView4;
    public Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageloadglide_layout);
        context = this;
        imageView1 = (ImageView) findViewById(R.id.ImageViewglide1);
        imageView2 = (ImageView) findViewById(R.id.ImageViewglide2);
        imageView3 = (ImageView) findViewById(R.id.ImageViewglide3);
        imageView4 = (ImageView) findViewById(R.id.ImageViewglide4);

        Glide.with(context)
                .load("https://source.unsplash.com/random")
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        // log exception
                        Log.e("TAG", "Error loading image", e);
                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(imageView1);

        Glide.with(context)
                .load("https://source.unsplash.com/random")
                .override(300, 200)
                .into(imageView2);

        Glide.with(context)
                .load("https://source.unsplash.com/random")
                .placeholder(R.drawable.hearticon)
                .error(R.drawable.fab_plus)
                .into(imageView3);

        Glide.with(context)
                .load("https://source.unsplash.com/random")
                .centerCrop()
                .into(imageView4);
    }


}
