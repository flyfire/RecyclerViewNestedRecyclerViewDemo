package com.solarexsoft.recyclerviewnestedrecyclerviewdemo;

import android.view.View;

/**
 * <pre>
 *    Author: houruhou
 *    Project: https://solarex.github.io/projects
 *    CreatAt: 17:19/2018/7/3
 *    Copyright: houruhou
 *    Desc:
 * </pre>
 */
public class BaseViewHolderFactory {
    public static final int TYPE_EASY = R.layout.item_view_one;
    public static final int TYPE_HARD = R.layout.item_view_two;

    public static BaseViewHolder createFrom(int viewtype, View convertview) {
        BaseViewHolder viewHolder = null;
        switch (viewtype) {
            case TYPE_EASY:
                viewHolder = new EasyViewHolder(convertview);
                break;
            case TYPE_HARD:
                viewHolder = new HardViewHolder(convertview);
                break;
        }
        return viewHolder;
    }

    public static int type(String modeltype) {
        if (Constants.EASY.equalsIgnoreCase(modeltype)) {
            return TYPE_EASY;
        } else if (Constants.HARD.equalsIgnoreCase(modeltype)) {
            return TYPE_HARD;
        }
        return -1;
    }
}
