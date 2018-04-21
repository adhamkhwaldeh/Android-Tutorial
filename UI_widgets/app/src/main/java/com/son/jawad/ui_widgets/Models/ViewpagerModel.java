package com.son.jawad.ui_widgets.Models;

/**
 * Created by Adhamkh on 2017-08-29.
 */

public class ViewpagerModel {
    public String ImageUrl;
    public String Title;

    public ViewpagerModel(String imageUrl, String title) {
        ImageUrl = imageUrl;
        Title = title;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
