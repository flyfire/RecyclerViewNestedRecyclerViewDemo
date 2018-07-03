package com.solarexsoft.recyclerviewnestedrecyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 17:17/2018/7/3
 *    Copyright: houruhou
 *    Desc:
 * </pre>
 */
public class ModelDataAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    List<ModelData> mModelData;

    public ModelDataAdapter() {
    }

    public void setModelData(List<ModelData> data) {
        mModelData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return BaseViewHolderFactory.createFrom(viewType, view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        ModelData data = mModelData.get(position);
        holder.bindData(data, position);
    }

    @Override
    public int getItemCount() {
        if (mModelData != null) {
            return mModelData.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        ModelData data = mModelData.get(position);
        return BaseViewHolderFactory.type(data.getType());
    }


}
