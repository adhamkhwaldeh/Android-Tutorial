package com.son.jawad.ui_widgets.Models;

/**
 * Created by Adhamkh on 2017-08-28.
 */

public class RecyclerViewModel {
    public String name;
    public String ImageUrl;
    public String Descriptions;
    public Float Rating;

    public RecyclerViewModel(String name, String imageUrl, String descriptions, Float rating) {
        this.name = name;
        ImageUrl = imageUrl;
        Descriptions = descriptions;
        Rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRating() {
        return Rating;
    }

    public void setRating(Float rating) {
        Rating = rating;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String descriptions) {
        Descriptions = descriptions;
    }
}
