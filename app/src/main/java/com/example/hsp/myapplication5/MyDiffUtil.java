package com.example.hsp.myapplication5;

import android.support.v7.util.DiffUtil;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HSP on 2017-12-25.
 */

public class MyDiffUtil extends DiffUtil.Callback {

    List<GroupItem> oldItem;
    List<GroupItem> newItem;
    int oldSize;
    int newSize;

    public MyDiffUtil(List<GroupItem> oldItem, List<GroupItem> newItem, int oldSize,int newSize) {
        this.oldItem = oldItem;
        this.newItem = newItem;
        this.oldSize = oldSize;
        this.newSize = newSize;
    }



    @Override
    public int getOldListSize() {
        return oldSize;
    }

    @Override
    public int getNewListSize() {
        return newSize;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        //일단 올드에 누가 열려있는지 확인!! 열려있는 애들과 헤더는 전부 리턴 true



        int p = 0;
        int SIZE = newItem.size();

        for(int i = 0; i < SIZE; ++i) {
            if(newItemPosition - p == 0) {
                return true;
            }
            if((newItem.get(i)).isExpend) {
                p += (newItem.get(i)).childItems.size() + 1;
            } else {
                ++p;
            }
        }

        return false;






    }
    public int aaa(int a) {
        int SIZE = newItem.size();
        int p = 0;
        int re = 0;

        for(int i = 0; i < SIZE; ++i) {
            if(p == a) {
                return i;
            }
            if((newItem.get(i)).isExpend) {
                p += (newItem.get(i)).childItems.size() + 1;
            } else {
                ++p;
            }
        }
        return re;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }
}
