package com.son.jawad.ui_widgets.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-29.
 */

public class TabViewPageFragment extends Fragment {

    public static String ARG_PAGE = "PositionTag";

    public int mPage = 0;

    public static TabViewPageFragment newInstance(int position) {
        TabViewPageFragment tabViewPageFragment = new TabViewPageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_PAGE, position);
        tabViewPageFragment.setArguments(bundle);
        return tabViewPageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabviewpagefragment_layout, container, false);
        TextView textView = (TextView) view.findViewById(R.id.texttitle);
        textView.setText("Fragment #" + mPage);
        return view;
    }


}
