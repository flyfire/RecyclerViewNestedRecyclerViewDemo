package com.solarexsoft.recyclerviewnestedrecyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 17:35/2018/7/3
 *    Copyright: houruhou
 *    Desc:
 * </pre>
 */
public class SubViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_icon)
    ImageView iv_icon;
    @BindView(R.id.tv_content)
    TextView tv_content;

    public SubViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
