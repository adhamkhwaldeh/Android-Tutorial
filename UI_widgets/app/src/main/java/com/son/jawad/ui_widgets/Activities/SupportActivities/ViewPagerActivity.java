package com.son.jawad.ui_widgets.Activities.SupportActivities;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.son.jawad.tutoriallibrary.ViewPagerIndicator.CircleIndicator.CircleIndicator;
import com.son.jawad.tutoriallibrary.ViewPagerIndicator.InkPageIndicator.InkPageIndicator;
import com.son.jawad.tutoriallibrary.ViewPagerIndicator.SpringIndicator.SpringIndicator;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.AccordionTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.BackgroundToForegroundTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.CubeInTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.CubeOutTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.DefaultTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.DepthPageTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.DrawerTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.FlipHorizontalTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.FlipVerticalTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.ForegroundToBackgroundTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.RotateDownTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.RotateUpTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.ScaleInOutTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.StackTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.TabletTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.ZoomInTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.ZoomOutSlideTransformer;
import com.son.jawad.tutoriallibrary.ViewPagerTransformation.ZoomOutTransformer;
import com.son.jawad.ui_widgets.Adapters.ViewPagerNoFragAdapter;
import com.son.jawad.ui_widgets.MainActivity;
import com.son.jawad.ui_widgets.Models.ModelsHelper;
import com.son.jawad.ui_widgets.Models.ViewpagerModel;
import com.son.jawad.ui_widgets.R;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Adhamkh on 2017-08-29.
 */

public class ViewPagerActivity extends Activity {

    private static final String KEY_SELECTED_PAGE = "KEY_SELECTED_PAGE";
    private static final String KEY_SELECTED_CLASS = "KEY_SELECTED_CLASS";
    private static final ArrayList<TransformerItem> TRANSFORM_CLASSES;
    private int mSelectedItem;

    static {
        TRANSFORM_CLASSES = new ArrayList<>();
        TRANSFORM_CLASSES.add(new TransformerItem(DefaultTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(AccordionTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(BackgroundToForegroundTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(CubeInTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(CubeOutTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(DepthPageTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(FlipHorizontalTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(FlipVerticalTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(ForegroundToBackgroundTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(RotateDownTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(RotateUpTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(ScaleInOutTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(StackTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(TabletTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(ZoomInTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(ZoomOutSlideTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(ZoomOutTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(DrawerTransformer.class));
    }

    public ViewPager viewpager;
    public TextSwitcher textSwitcher;
    public InkPageIndicator mIndicator;
    public CircleIndicator indicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.viewpager_layout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setAdapter(new ViewPagerNoFragAdapter(ViewPagerActivity.this, ModelsHelper.getViewpagerModelList()));
        viewpager.setOffscreenPageLimit(4);
        viewpager.setClipToPadding(false);
//        viewpager.setPageMargin(12);
        //setTextSwitcher();
        setSpringIndicator();
        //  setCircleIndicator();
        //  setInkindicator();
        setTransform(savedInstanceState);
    }

    public void setTextSwitcher() {
        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(mFactory);

        /*
         * Set the in and out animations. Using the fade_in/out animations
         * provided by the framework.
         */
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);
        textSwitcher.setInAnimation(in);
        textSwitcher.setOutAnimation(out);


        //  viewpager.setPageMargin(-50);
        //viewpager.setHorizontalFadingEdgeEnabled(true);
        //viewpager.setFadingEdgeLength(30);


        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                String title = ((ViewPagerNoFragAdapter) viewpager.getAdapter()).viewpagerModelList.get(position).Title;
                textSwitcher.setText(title);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public void setSpringIndicator() {
              /*SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
        // just set viewPager
        springIndicator.setViewPager(viewpager);*/
    }

    public void setCircleIndicator() {
        indicator = (CircleIndicator) findViewById(R.id.indicator_custom);
        indicator.setViewPager(viewpager);
    }

    public void setInkindicator() {
        mIndicator = (InkPageIndicator) findViewById(R.id.Inkindicator);
        mIndicator.setViewPager(viewpager);
    }

    public void setTransform(@Nullable Bundle savedInstanceState) {
        int selectedPage = 0;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(KEY_SELECTED_CLASS);
            selectedPage = savedInstanceState.getInt(KEY_SELECTED_PAGE);
        }

        final ArrayAdapter<TransformerItem> actionBarAdapter = new ArrayAdapter<TransformerItem>(
                getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, TRANSFORM_CLASSES);

        final ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setListNavigationCallbacks(actionBarAdapter, new ActionBar.OnNavigationListener() {
                @Override
                public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                    mSelectedItem = itemPosition;
                    try {
                        viewpager.setPageTransformer(true, TRANSFORM_CLASSES.get(itemPosition).clazz.newInstance());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return true;
                }
            });
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

            //noinspection ResourceType
            actionBar.setDisplayOptions(actionBar.getDisplayOptions() ^ ActionBar.DISPLAY_SHOW_TITLE);

            actionBar.setSelectedNavigationItem(mSelectedItem);
        }

    }

    private ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory() {

        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView(ViewPagerActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(ViewPagerActivity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };


    private static final class TransformerItem {

        final String title;
        final Class<? extends ViewPager.PageTransformer> clazz;

        public TransformerItem(Class<? extends ViewPager.PageTransformer> clazz) {
            this.clazz = clazz;
            title = clazz.getSimpleName();
        }

        @Override
        public String toString() {
            return title;
        }

    }

}
