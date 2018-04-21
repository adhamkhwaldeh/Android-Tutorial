package com.son.jawad.ui_widgets.Activities.DesignPatternActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.son.jawad.ui_widgets.R;

import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Adhamkh on 2017-09-17.
 */

public class CodeInjectionActivity extends AppCompatActivity {

    @BindView(R.id.sample_text)
    TextView textView;
    @BindView(R.id.sample_button)
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.codeinjection_layout);
        ButterKnife.bind(this);
        textView.setText("You can change this view accordingly");

    }

    @OnClick(R.id.click_button)
    void buttonClick() {
        Toast.makeText(getApplicationContext(), "adsdassda", Toast.LENGTH_LONG).show();
    }
}
