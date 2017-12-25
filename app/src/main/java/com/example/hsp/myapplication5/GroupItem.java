package com.example.hsp.myapplication5;

import java.util.ArrayList;

/**
 * Created by HSP on 2017-12-24.
 */

public class GroupItem {

    boolean isExpend=false;
    ArrayList<ChildItem> childItems;

    int id;
    int rating;
    String name;

    public GroupItem(ArrayList<ChildItem> childItems, int id, int rating, String name) {
        this.childItems = childItems;
        this.id = id;
        this.rating = rating;
        this.name = name;
    }

    public boolean isExpend() {
        return isExpend;
    }

    public ArrayList<ChildItem> getChildItems() {
        return childItems;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }
}
