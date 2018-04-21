package com.son.jawad.ui_widgets.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-25.
 */

public class CounterFragment extends Fragment {

    public static String FranumberFlag = "FranumberFlag", FragversionFlag = "FragversionFlag";

    public static String Fragnumber, FragVersion;

    public static CounterFragment newInstance(String Fragnumber, String FragVersion) {
        CounterFragment f = new CounterFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putString(FranumberFlag, Fragnumber);
        args.putString(FragversionFlag, FragVersion);
        f.setArguments(args);
        return f;
    }

    public TextView fragtextview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.counterfragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            fragtextview = (TextView) view.findViewById(R.id.fragtextview);
            Fragnumber = getArguments().getString(FranumberFlag);
            FragVersion = getArguments().getString(FragversionFlag);
            fragtextview.setText(Fragnumber + "-" + FragVersion);
        } else {
            fragtextview.setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

}
