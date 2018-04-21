package com.son.jawad.ui_widgets.Activities.AnimationActivities.CustomRipple;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.son.jawad.tutoriallibrary.AnimationViews.Ripples.MaterialRippleLayout;
import com.son.jawad.ui_widgets.R;


public class MaterialRippleActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materialripple_layout);

        // xml initialization
        findViewById(R.id.ripple_layout_1).setOnClickListener(this);
        findViewById(R.id.ripple_layout_1).setOnLongClickListener(this);

        // static initialization
        View view = findViewById(R.id.ripple_layout_2);
        MaterialRippleLayout.on(view)
            .rippleColor(Color.parseColor("#FF0000"))
            .rippleAlpha(0.2f)
            .rippleHover(true)
            .create();

        view.setOnLongClickListener(this);
        view.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        Toast.makeText(this, "Short click", Toast.LENGTH_SHORT).show();
    }

    @Override public boolean onLongClick(View v) {
        if (v.getId() == R.id.ripple_layout_1) {
            Toast.makeText(this, "Long click not consumed", Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(this, "Long click and consumed", Toast.LENGTH_SHORT).show();
        return true;
    }

}
