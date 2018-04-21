package com.son.jawad.ui_widgets.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

import com.son.jawad.ui_widgets.R;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Adhamkh on 2017-08-18.
 */

public class CounterTextView extends TextView {
///
    public boolean IsStart;
    public int MinuteColor, SecondColor;
    public Calendar startcalendar;

    public CounterTextView(Context context) {
        super(context);

    }

    public CounterTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public CounterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //init(context, attrs);
    }


    public void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.CounterTextView);
        try {
            IsStart = typedArray.getBoolean(R.styleable.CounterTextView_IsStart, true);
            MinuteColor = typedArray.getColor(R.styleable.CounterTextView_MinuteColor, getResources().getColor(R.color.colorPrimary));
            SecondColor = typedArray.getColor(R.styleable.CounterTextView_SecondColor, getResources().getColor(R.color.colorAccent));
            if (IsStart) {
                startcalendar = Calendar.getInstance(Locale.getDefault());
            }
        } finally {
            // for reuse
            typedArray.recycle();
        }
    }

    @Override

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (IsStart) {
            Long def = Calendar.getInstance(Locale.getDefault()).getTimeInMillis() - startcalendar.getTimeInMillis();
            Long mnt = def / 60000;
            def = (def - mnt * 60000) / 1000;
            String s = String.format(Locale.getDefault(), "%2d:%2d", mnt, def);
            CounterTextView.this.setText(s);
            invalidate();
        }
    }

    public void getstart(Boolean isStart) {
        this.IsStart = isStart;
        if (IsStart) {
            startcalendar = Calendar.getInstance(Locale.getDefault());
        }
        invalidate();
    }

}
