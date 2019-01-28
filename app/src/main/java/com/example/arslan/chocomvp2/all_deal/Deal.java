package com.example.arslan.chocomvp2.all_deal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deal {
    @SerializedName("deal_id")
    @Expose
    private int deal_id;

    @SerializedName("price")
    @Expose
    private int price;

    @SerializedName("discount")
    @Expose
    private int discount;

    @SerializedName("title_short")
    @Expose
    private String title_short;

    @SerializedName("reviews_rate")
    @Expose
    private double reviews_rate;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("bought")
    @Expose
    private int bought;

    @SerializedName("image_kind")
    @Expose
    private String imageKind;

    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    @SerializedName("image_url_wide")
    @Expose
    private String imageUrlWide;


    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getTitle_short() {
        return title_short;
    }

    public void setTitle_short(String title_short) {
        this.title_short = title_short;
    }

    public double getReviews_rate() {
        return reviews_rate;
    }

    public void setReviews_rate(double reviews_rate) {
        this.reviews_rate = reviews_rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBought() {
        return bought;
    }

    public void setBought(int bought) {
        this.bought = bought;
    }

    public String getImageKind() {
        return imageKind;
    }

    public void setImageKind(String imageKind) {
        this.imageKind = imageKind;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrlWide() {
        return imageUrlWide;
    }

    public void setImageUrlWide(String imageUrlWide) {
        this.imageUrlWide = imageUrlWide;
    }
}
