package com.example.demoapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.utils.MenuItemModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MyViewHolder> {
    private List<MenuItemModel> mDataset;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView location;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textView);
            this.location = itemView.findViewById(R.id.location);
            this.imageView = itemView.findViewById(R.id.imageView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }


    public DetailAdapter(List<MenuItemModel> list, Context context) {
        mDataset = list;
        this.context = context;
    }

    @Override
    public DetailAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item_view, parent, false);
        DetailAdapter.MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final MenuItemModel menuItemModel = mDataset.get(position);
        holder.textView.setText(menuItemModel.getName());
        Picasso.get().load(menuItemModel.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
