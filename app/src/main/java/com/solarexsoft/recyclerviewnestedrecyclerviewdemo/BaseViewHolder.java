package com.solarexsoft.recyclerviewnestedrecyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 17:09/2018/7/3
 *    Copyright: houruhou
 *    Desc:
 * </pre>
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindData(T data, int position);
}
