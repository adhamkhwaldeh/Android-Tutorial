package com.son.jawad.ui_widgets.Activities.ImageLoaderActivities;

import android.content.Context;
import android.net.Uri;
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
import com.squareup.picasso.Picasso;

/**
 * Created by Adhamkh on 2017-09-03.
 */

public class ImageLoadpicassoActivity extends AppCompatActivity {
    public ImageView imageView1, imageView2, imageView3, imageView4;
    public Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageloadpicasso_layout);
        context = this;
        imageView1 = (ImageView) findViewById(R.id.ImageViewglide1);
        imageView2 = (ImageView) findViewById(R.id.ImageViewglide2);
        imageView3 = (ImageView) findViewById(R.id.ImageViewglide3);
        imageView4 = (ImageView) findViewById(R.id.ImageViewglide4);

        Picasso.Builder builder = new Picasso.Builder(getApplicationContext());
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                exception.printStackTrace();
            }
        });

        builder.build().
                load("https://source.unsplash.com/random")
                .into(imageView1);

        Picasso.with(context)
                .load("https://source.unsplash.com/random")
                .resize(300, 200).into(imageView2);

        Picasso.with(context)
                .load("https://source.unsplash.com/random").placeholder(R.drawable.hearticon)
                .error(R.drawable.fab_plus)
                .into(imageView3);

        Picasso.with(context).load("https://source.unsplash.com/random").resize(300,200).centerCrop()
                .into(imageView4);

    }
}
