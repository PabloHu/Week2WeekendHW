package com.example.admin.week2weekendhw;

/**
 * Created by Admin on 9/9/2017.
 */

public class ListViewObject {
    int id;
    String name;
    String icon;
    Boolean isFavorite;


    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String iconLocation) {
        this.icon = iconLocation;
    }

}
