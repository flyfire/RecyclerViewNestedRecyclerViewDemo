package com.solarexsoft.recyclerviewnestedrecyclerviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 16:30/2018/7/6
 *    Desc:
 * </pre>
 */
public class SecondActivity extends AppCompatActivity {
    public static final String KEY_PARAMS = "key_params";

    private int mPosition;
    public static void goSecondActivity(Activity activity, int position) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra(KEY_PARAMS, position);
        activity.startActivityForResult(intent, 0);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null) {
            mPosition = intent.getIntExtra(KEY_PARAMS, 0);
        }
    }

    @OnClick(R.id.btn_back)
    public void click(){
        Intent intent = new Intent();
        intent.putExtra(KEY_PARAMS, mPosition);
        setResult(RESULT_OK, intent);
        finish();
    }
}
