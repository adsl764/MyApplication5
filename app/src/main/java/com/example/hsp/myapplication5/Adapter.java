package com.example.hsp.myapplication5;

import android.content.Context;
import android.service.voice.AlwaysOnHotwordDetector;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HSP on 2017-12-24.
 */

public class Adapter extends RecyclerView.Adapter {
    ArrayList<GroupItem> groupItems;
    ArrayList<GroupItem> groupItems1;
    Context context;
    LayoutInflater inflater;
    static final int HEADE = 0;
    static final int BODY = 1;

    int oldItemSize;

    public Adapter(ArrayList<GroupItem> groupItems, Context context) {
        this.groupItems = groupItems;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        groupItems1=groupItems;
        Log.i("asd", "" + groupItems.size());
    }

    public int getSize (){
        int a = groupItems.size();
        int groupSize = groupItems.size();

        for(int i = 0; i < groupSize; ++i) {
            if((groupItems.get(i)).isExpend) {
                a += (groupItems.get(i)).childItems.size();
            }
        }
        oldItemSize=a;
        return a;
    }
    public void swapItems(List<GroupItem> items,int size) {
        final MyDiffUtil diffCallback = new MyDiffUtil(this.groupItems, items,oldItemSize,size);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        groupItems.clear();
        groupItems.addAll(items);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View body;
        if(viewType == 0) {
            body = inflater.inflate(R.layout.head, parent, false);
            Adapter.MyViewHolder holder = new Adapter.MyViewHolder(body);
            return holder;
        } else if(viewType == 1) {
            body = this.inflater.inflate(R.layout.body, parent, false);
            Adapter.HeadViewHolder holder = new Adapter.HeadViewHolder(body);
            return holder;
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }



    public int getItemCount() {
        return getSize();
    }


    public int getItemViewType(int position) {
        int p = 0;
        int SIZE = this.groupItems.size();

        for(int i = 0; i < SIZE; ++i) {
            if(position - p == 0) {
                return 0;
            }
            if((groupItems.get(i)).isExpend) {
                p += (groupItems.get(i)).childItems.size() + 1;
            } else {
                ++p;
            }
        }

        return 1;
    }

    public int aaa(int a) {
        int SIZE = this.groupItems.size();
        int p = 0;
        int re = 0;

        for(int i = 0; i < SIZE; ++i) {
            if(p == a) {
                return i;
            }
            if((groupItems.get(i)).isExpend) {
                p += (groupItems.get(i)).childItems.size() + 1;
            } else {
                ++p;
            }
        }
        return re;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.layout = itemView.findViewById(R.id.head);
            this.layout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int posi=aaa(getLayoutPosition());
                    GroupItem item = groupItems.get(posi);
                    List<GroupItem> items=GroupRepository.getGroupItem();
                    Log.d("kkkk", String.valueOf(oldItemSize));


                    if((groupItems.get(aaa(getAdapterPosition()))).isExpend) {

                        for(int i=0;i<items.size()-1;i++){
                            items.get(i).isExpend=groupItems.get(i).isExpend;
                        }
                        items.get(posi).isExpend=!(items.get(posi).isExpend);
                        swapItems(items,oldItemSize-item.childItems.size());


                    } else {
                        for(int i=0;i<items.size()-1;i++){
                            items.get(i).isExpend=groupItems.get(i).isExpend;
                        }
                        items.get(posi).isExpend=!(items.get(posi).isExpend);
                        swapItems(items,oldItemSize+item.childItems.size());
                    }

//                    notifyDataSetChanged();


                }
            });
        }
    }

    class HeadViewHolder extends RecyclerView.ViewHolder {
        public HeadViewHolder(View itemView) {
            super(itemView);
        }
    }
}