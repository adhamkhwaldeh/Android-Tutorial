package com.son.jawad.ui_widgets.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.son.jawad.tutoriallibrary.ImageCashFile.cache.ImageLoader;
import com.son.jawad.ui_widgets.R;

public class ImagecashAdapter extends BaseAdapter {

	private static final String TAG = "ImagecashAdapter";
	private boolean mBusy = false;

	public void setFlagBusy(boolean busy) {
		this.mBusy = busy;
	}

	
	private ImageLoader mImageLoader;
	private int mCount;
	private Context mContext;
	private String[] urlArrays;
	
	
	public ImagecashAdapter(int count, Context context, String[]url) {
		this.mCount = count;
		this.mContext = context;
		urlArrays = url;
		mImageLoader = new ImageLoader(context);
	}
	
	public ImageLoader getImageLoader(){
		return mImageLoader;
	}

	@Override
	public int getCount() {
		return mCount;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.imagecashfile_item, null);
			viewHolder = new ViewHolder();
			viewHolder.mTextView = (TextView) convertView
					.findViewById(R.id.tv_tips);
			viewHolder.mImageView = (ImageView) convertView
					.findViewById(R.id.iv_image);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		String url = "";
		url = urlArrays[position % urlArrays.length];
		
		viewHolder.mImageView.setImageResource(R.drawable.ic_launcher);
		

		if (!mBusy) {
			mImageLoader.DisplayImage(url, viewHolder.mImageView, false);
			viewHolder.mTextView.setText("--" + position
					+ "--IDLE ||TOUCH_SCROLL");
		} else {
			mImageLoader.DisplayImage(url, viewHolder.mImageView, false);		
			viewHolder.mTextView.setText("--" + position + "--FLING");
		}
		return convertView;
	}

	static class ViewHolder {
		TextView mTextView;
		ImageView mImageView;
	}
}
