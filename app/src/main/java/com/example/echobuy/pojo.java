package com.example.echobuy;

import java.io.Serializable;

public class pojo implements Serializable {
    private String title;
    private int imageResource;
    private String text2;
    private String text3;

    public pojo(String title, int imageResource, String text2, String text3) {
        this.title = title;
        this.imageResource = imageResource;
        this.text2 = text2;
        this.text3 = text3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }
}
