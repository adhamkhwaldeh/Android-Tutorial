package com.son.jawad.ui_widgets.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.son.jawad.ui_widgets.Models.SpinnerModel;
import com.son.jawad.ui_widgets.R;

import java.util.List;

/**
 * Created by Adhamkh on 2017-08-15.
 */

public class CustomSpinnerAdapter extends BaseAdapter {
    public Context context;
    public List<SpinnerModel> spinnerModelList;
    public LayoutInflater layoutInflater;

    public CustomSpinnerAdapter(Context context, List<SpinnerModel> spinnerModelList) {
        this.context = context;
        this.spinnerModelList = spinnerModelList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return spinnerModelList == null ? 0 : spinnerModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return spinnerModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.spinner_item2, null, false);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.text1);
        nameTextView.setText(spinnerModelList.get(position).getName());
        Button deletebtn = (Button) convertView.findViewById(R.id.deletebtn);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerModelList.remove(position);
                CustomSpinnerAdapter.this.notifyDataSetChanged();
            }
        });

        return convertView;
    }

}
