package com.son.jawad.ui_widgets.Enums;

/**
 * Created by Adhamkh on 2017-08-28.
 */

public enum RecyclerViewPageType {
    List_Type(1), Grid_Type(2), Pager_Type(3), Staggered_Type(4);
    int val;

    RecyclerViewPageType(int val) {
        this.val = val;
    }

}
