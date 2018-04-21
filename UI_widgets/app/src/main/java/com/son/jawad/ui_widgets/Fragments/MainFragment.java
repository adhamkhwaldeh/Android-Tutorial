package com.son.jawad.ui_widgets.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.son.jawad.ui_widgets.R;

import java.util.List;

/**
 * Created by Adhamkh on 2017-08-21.
 */

public class MainFragment extends Fragment {

    public static MainFragment newInstance() {
        MainFragment f = new MainFragment();

        // Supply num input as an argument.
//        Bundle args = new Bundle();
//        args.putInt("num", num);
        // f.setArguments(args);
        return f;
    }

    public Button addfragment, replacefragment, removefragment;
    public LinearLayout faglayout;
    public Integer counter = 0;
    public Integer[] version;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mainfragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addfragment = (Button) view.findViewById(R.id.addfragment);
        replacefragment = (Button) view.findViewById(R.id.replacefragment);
        removefragment = (Button) view.findViewById(R.id.removefragment);
        faglayout = (LinearLayout) view.findViewById(R.id.fraglayout);
        version = new Integer[100];
        for (int i = 0; i < 100; i++)
            version[i] = Integer.valueOf(0);

        addfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onaddfragment(v);
            }
        });

        replacefragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onreplace(v);
            }
        });

        removefragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onremove(v);
            }
        });

    }


    public void onaddfragment(View view) {
        counter++;
        version[counter]++;
        CounterFragment counterFragment = CounterFragment.newInstance(counter.toString(), version[counter].toString());
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().
                add(R.id.fraglayout, counterFragment, counter.toString()).addToBackStack(counter.toString())
                .commit();
        fragmentManager = getFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments.size() > 1)
            fragmentManager.beginTransaction().show(fragments.get(fragments.size() - 1)).commit();
        for (int i = 1; i < fragments.size(); i++) {
            if (fragments.get(i) != null)
                fragmentManager.beginTransaction().hide(fragments.get(i)).commit();
            else
                Log.v("NullFragment", "NULL Fragment");
        }
    }

    public void onreplace(View view) {
        counter++;
        version[counter]++;
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().
                replace(R.id.fraglayout, CounterFragment.newInstance(counter.toString(), version[counter].toString()))
                .commit();
    }

    public void onremove(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        Fragment rmv = fragmentManager.getFragments().get(fragments.size() - 1);
        if (rmv != null) {
            fragmentManager.beginTransaction()
                    .remove(rmv)
                    .commit();
        } else {
            Integer integer = fragmentManager.getBackStackEntryCount();
            fragmentManager.popBackStack();
        }
        fragments = fragmentManager.getFragments();
        if (fragments.size() > 1)
            fragmentManager.beginTransaction().show(fragments.get(fragments.size() - 1)).commit();

    }


}
