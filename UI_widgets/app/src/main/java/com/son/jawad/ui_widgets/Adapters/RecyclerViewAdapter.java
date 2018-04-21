package com.son.jawad.ui_widgets.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.son.jawad.ui_widgets.Enums.RecyclerViewPageType;
import com.son.jawad.ui_widgets.Listeners.RecyclerViewItemClickListener;
import com.son.jawad.ui_widgets.Models.RecyclerViewModel;
import com.son.jawad.ui_widgets.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Adhamkh on 2017-08-28.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    public Context context;
    public List<RecyclerViewModel> recyclerViewModelList;
    public RecyclerViewPageType recyclerViewPageType;
    public RecyclerViewItemClickListener recyclerViewItemClickListener;

    public RecyclerViewAdapter(Context context, List<RecyclerViewModel> recyclerViewModelList,
                               RecyclerViewPageType recyclerViewPageType,
                               RecyclerViewItemClickListener recyclerViewItemClickListener) {
        this.recyclerViewItemClickListener = recyclerViewItemClickListener;
        this.context = context;
        this.recyclerViewModelList = recyclerViewModelList;
        this.recyclerViewPageType = recyclerViewPageType;
    }

    public RecyclerViewAdapter(Context context, List<RecyclerViewModel> recyclerViewModelList,
                               RecyclerViewPageType recyclerViewPageType) {
        this.context = context;
        this.recyclerViewModelList = recyclerViewModelList;
        this.recyclerViewPageType = recyclerViewPageType;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (recyclerViewPageType == RecyclerViewPageType.Grid_Type)
            return new MyViewHolder(inflater.inflate(R.layout.recyclerviewgrid_item, parent, false));
        else if (recyclerViewPageType == RecyclerViewPageType.List_Type)
            return new MyViewHolder(inflater.inflate(R.layout.recyclerviewlist_item, parent, false));
        else if (recyclerViewPageType == RecyclerViewPageType.Pager_Type)
            return new MyViewHolder(inflater.inflate(R.layout.recyclerviewpager_item, parent, false));
        else if (recyclerViewPageType == RecyclerViewPageType.Staggered_Type)
            return new MyViewHolder(inflater.inflate(R.layout.recyclerviewstaggered_item, parent, false));
        else
            return new MyViewHolder(inflater.inflate(R.layout.recyclerviewlist_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecyclerViewModel recyclerViewmodel = recyclerViewModelList.get(position);
        holder.name.setText(recyclerViewmodel.getName());
        holder.Rating.setRating(recyclerViewmodel.getRating());
        holder.Descriptions.setText(recyclerViewmodel.getDescriptions());

        Picasso.with(context).load(recyclerViewmodel.getImageUrl())
                .memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE)
                .fit().placeholder(R.drawable.chip).error(R.mipmap.ic_launcher).into(holder.Image,
                new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        Log.v("ErrorLoad", "ErrorLoad");
                    }
                });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recyclerViewItemClickListener != null)
                    recyclerViewItemClickListener.onItemClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return recyclerViewModelList == null ? 0 : recyclerViewModelList.size();
    }

    public void updatelayout(RecyclerViewPageType recyclerViewPageType) {
        this.recyclerViewPageType = recyclerViewPageType;
        if (recyclerViewModelList != null) {
            for (int i = 0; i < recyclerViewModelList.size(); i++)
                notifyItemRemoved(i);
            for (int i = 0; i < recyclerViewModelList.size(); i++)
                notifyItemInserted(i);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView Descriptions;
        public ImageView Image;
        public RatingBar Rating;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            Descriptions = (TextView) itemView.findViewById(R.id.Descriptions);
            Image = (ImageView) itemView.findViewById(R.id.Image);
            Rating = (RatingBar) itemView.findViewById(R.id.Rating);
        }
    }

}
