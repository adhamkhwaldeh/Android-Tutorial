package com.son.jawad.ui_widgets.Activities.UIActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.son.jawad.ui_widgets.Adapters.CustomSpinnerAdapter;
import com.son.jawad.ui_widgets.Models.SpinnerModel;
import com.son.jawad.ui_widgets.R;

import java.util.List;
import java.util.Vector;

/**
 * Created by Adhamkh on 2017-08-15.
 */
public class SpinnerActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener {

    Spinner spinner, spinner2, spinner3, spinner4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_layout);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);

        String names[] = {"name1", "name2", "name3", "name4", "name5", "name6", "name7", "name8", "name9", "name10"};

        spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, names));
        spinner.setOnItemSelectedListener(this);

        spinner2.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, names));
        spinner2.setOnItemSelectedListener(this);


        List<SpinnerModel> namesmodel = new Vector<>();
        namesmodel.add(new SpinnerModel("name1"));
        namesmodel.add(new SpinnerModel("name2"));
        namesmodel.add(new SpinnerModel("name3"));
        namesmodel.add(new SpinnerModel("name4"));
        namesmodel.add(new SpinnerModel("name5"));
        namesmodel.add(new SpinnerModel("name6"));
        namesmodel.add(new SpinnerModel("name7"));
        namesmodel.add(new SpinnerModel("name8"));
        namesmodel.add(new SpinnerModel("name9"));
        namesmodel.add(new SpinnerModel("name10"));
        spinner3.setAdapter(new ArrayAdapter<SpinnerModel>(this, R.layout.spinner_item, namesmodel));
        spinner3.setOnItemSelectedListener(this);

        spinner4.setAdapter(new CustomSpinnerAdapter(SpinnerActivity.this, namesmodel));
        spinner4.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String s = parent.getSelectedItem().toString();
        Toast.makeText(SpinnerActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
