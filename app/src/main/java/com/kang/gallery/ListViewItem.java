package com.kang.gallery;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable;
    private String titleStr;
    private String nemStr;

    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }
    public void setTitle(String title) { titleStr = title; }
    public void setNum(String num) {
        nemStr = num;
    }

    public Drawable getIcon() {
        return this.iconDrawable;
    }
    public String getTitle() {
        return this.titleStr;
    }
    public String getNum() {
        return this.nemStr;
    }
}