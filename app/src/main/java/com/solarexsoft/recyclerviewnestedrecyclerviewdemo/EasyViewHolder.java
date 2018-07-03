package com.solarexsoft.recyclerviewnestedrecyclerviewdemo;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 17:33/2018/7/3
 *    Copyright: houruhou
 *    Desc:
 * </pre>
 */
public class EasyViewHolder extends BaseViewHolder<ModelData> {
    @BindView(R.id.tv_title)
    TextView tv_title;

    public EasyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(ModelData data, int position) {
        tv_title.setText(data.getTitle());
    }
}
