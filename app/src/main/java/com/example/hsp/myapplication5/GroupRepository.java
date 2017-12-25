package com.example.hsp.myapplication5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HSP on 2017-12-25.
 */

public class GroupRepository {

    public static List<GroupItem> getGroupItem(){
        ArrayList<GroupItem> groupItems = new ArrayList();
        ArrayList<ChildItem> childItems1 = new ArrayList();
        ArrayList<ChildItem> childItems2 = new ArrayList();
        ArrayList<ChildItem> childItems3 = new ArrayList();
        ArrayList<ChildItem> childItems4 = new ArrayList();
        childItems1.add(new ChildItem(1));
        childItems1.add(new ChildItem(2));
        childItems1.add(new ChildItem(3));
        childItems1.add(new ChildItem(4));
        groupItems.add(new GroupItem(childItems1,1,1,"ch1"));
        childItems2.add(new ChildItem(1));
        childItems2.add(new ChildItem(2));
        childItems2.add(new ChildItem(3));
        groupItems.add(new GroupItem(childItems2,2,2,"ch2"));
        childItems3.add(new ChildItem(1));
        childItems3.add(new ChildItem(2));
        groupItems.add(new GroupItem(childItems3,3,3,"ch3"));
        childItems4.add(new ChildItem(1));
        groupItems.add(new GroupItem(childItems4,4,4,"ch4"));
        return groupItems;
    }
}
