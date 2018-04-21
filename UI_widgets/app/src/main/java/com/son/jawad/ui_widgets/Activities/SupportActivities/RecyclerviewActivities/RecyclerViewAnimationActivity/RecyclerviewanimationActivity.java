package com.son.jawad.ui_widgets.Activities.SupportActivities.RecyclerviewActivities.RecyclerViewAnimationActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Wasabeef on 2015/03/08.
 */
public class RecyclerviewanimationActivity extends AppCompatActivity {

    private boolean enabledGrid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerviewanimation_layout);

        findViewById(R.id.btn_animator_sample).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecyclerviewanimationActivity.this, AnimatorSampleActivity.class);
                i.putExtra("GRID", enabledGrid);
                startActivity(i);
            }
        });

        findViewById(R.id.btn_adapter_sample).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecyclerviewanimationActivity.this, AdapterSampleActivity.class);
                i.putExtra("GRID", enabledGrid);
                startActivity(i);
            }
        });

        ((SwitchCompat) findViewById(R.id.grid)).setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        enabledGrid = isChecked;
                    }
                });
    }
}
