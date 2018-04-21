package com.son.jawad.ui_widgets.Activities.ImageLoaderActivities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.son.jawad.ui_widgets.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;
import java.util.Vector;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by Adhamkh on 2017-09-03.
 */

public class ImageLoadpicassoTransformationActivity extends AppCompatActivity {
    public ImageView imageView1, imageView2, imageView3, imageView4;
    public Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageloadpicassotransformation_layout);
        context = this;
        imageView1 = (ImageView) findViewById(R.id.ImageViewglide1);
        imageView2 = (ImageView) findViewById(R.id.ImageViewglide2);
        imageView3 = (ImageView) findViewById(R.id.ImageViewglide3);
        imageView4 = (ImageView) findViewById(R.id.ImageViewglide4);

        int radius = 30; // corner radius, higher value = more rounded
        int margin = 10; // crop margin, set to 0 for corners with no crop
        Picasso.with(this)
                .load("https://source.unsplash.com/random")
                .transform(new RoundedCornersTransformation(radius, margin))
                .into(imageView1);

        Picasso.with(this)
                .load("https://source.unsplash.com/random")
                .transform(new CropCircleTransformation())
                .into(imageView2);

        Picasso.with(this)
                .load("https://source.unsplash.com/random")
                .transform(new BlurTransformation(context, 25))
                .into(imageView3);


        List<Transformation> transformationList = new Vector<>();
        transformationList.add(new CropCircleTransformation());
        transformationList.add(new BlurTransformation(context, 25));

        Picasso.with(this)
                .load("https://source.unsplash.com/random")
                .transform(transformationList)
                .into(imageView4);

    }
}
