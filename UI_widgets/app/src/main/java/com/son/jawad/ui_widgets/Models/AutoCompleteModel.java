package com.son.jawad.ui_widgets.Models;

/**
 * Created by Adhamkh on 2017-08-18.
 */

public class AutoCompleteModel {
    String name;

    public AutoCompleteModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
