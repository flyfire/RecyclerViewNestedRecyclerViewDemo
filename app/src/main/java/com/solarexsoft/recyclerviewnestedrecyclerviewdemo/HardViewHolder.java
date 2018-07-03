package com.solarexsoft.recyclerviewnestedrecyclerviewdemo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
public class HardViewHolder extends BaseViewHolder<ModelData> {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.rv_sub)
    RecyclerView rv_sub;

    public HardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(ModelData data, int position) {
        tv_title.setText(data.getTitle());
        SubDataAdapter adapter = new SubDataAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(rv_sub.getContext(),
                LinearLayoutManager.VERTICAL, false);
        rv_sub.setAdapter(adapter);
        rv_sub.setLayoutManager(layoutManager);
        adapter.setSubData(data.getSubdatas());
    }
}
