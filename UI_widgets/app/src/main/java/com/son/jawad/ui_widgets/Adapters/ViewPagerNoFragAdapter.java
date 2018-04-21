package com.son.jawad.ui_widgets.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.son.jawad.ui_widgets.Models.ViewpagerModel;
import com.son.jawad.ui_widgets.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ViewPagerNoFragAdapter extends PagerAdapter {

    public Context context;
    public List<ViewpagerModel> viewpagerModelList;
    public LayoutInflater mLayoutInflater;

    public ViewPagerNoFragAdapter(Context context, List<ViewpagerModel> viewpagerModelList) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.viewpagerModelList = viewpagerModelList;
    }

//    @Override
//    public float getPageWidth(int position) {
//        return 0.70f;
//    }

    @Override
    public int getCount() {
        return viewpagerModelList == null ? 0 : viewpagerModelList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final View itemView = mLayoutInflater.inflate(R.layout.viewpagergallary_item, container, false);

        ViewpagerModel viewpagerModel = viewpagerModelList.get(position);
        ImageView image = (ImageView) itemView.findViewById(R.id.image);
        Picasso.with(context).load(viewpagerModel.getImageUrl()).resize(400, 600).centerCrop().error(R.drawable.chip)
                .into(image);
        container.addView(itemView);
        return itemView;
    }

    // Removes the page from the container for the given position.
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf(position + 1);
    }
}
