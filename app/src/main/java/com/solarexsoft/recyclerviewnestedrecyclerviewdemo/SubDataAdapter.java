package com.solarexsoft.recyclerviewnestedrecyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 17:53/2018/7/3
 *    Copyright: houruhou
 *    Desc:
 * </pre>
 */
public class SubDataAdapter extends RecyclerView.Adapter<SubViewHolder> {
    public static final String TAG = "Solarex";

    List<ModelData.SubData> mSubData;

    public SubDataAdapter() {
    }

    public void setSubData(List<ModelData.SubData> data) {
        mSubData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_sub,
                parent, false);
        Log.d(TAG, "sub oncreateviewholder");
        return new SubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubViewHolder holder, int position) {
        ModelData.SubData data = mSubData.get(position);
        Log.d(TAG, "sub onbindviewholder " + position);
        Glide.with(holder.iv_icon.getContext()).load(data.getSubImgUrl()).into(holder.iv_icon);
        holder.tv_content.setText(data.getSubTitle());
    }

    @Override
    public int getItemCount() {
        if (mSubData != null) {
            return mSubData.size();
        }
        return 0;
    }
}
