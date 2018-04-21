package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * ListView subclass that provides an interface for (temporarily) blocking all of it's input events
 */
public class BlockableListView extends ListView {
    public BlockableListView(Context context) {
        super(context);
    }

    public BlockableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BlockableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private boolean touchEventsBlocked = false;

    /**
     * Prevent this ListView from receiving any new touch events
     *
     * Use {@link #unblockTouchEvents()} to end the blockage.
     */
    public void blockTouchEvents() {
        this.touchEventsBlocked = true;
    }

    /**
     * Stop preventing this ListView from receiving touch events
     */
    public void unblockTouchEvents() {
        this.touchEventsBlocked = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return this.touchEventsBlocked || super.onTouchEvent(ev);
    }
}
