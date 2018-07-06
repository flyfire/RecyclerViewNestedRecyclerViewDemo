package com.solarexsoft.recyclerviewnestedrecyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_main)
    RecyclerView rv_main;

    ModelDataAdapter adapter;
    List<ModelData> mockDatas;
    private int position;
    private int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mockDatas = generateDatas();
        size = mockDatas.size();
        position = 0;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        rv_main.setLayoutManager(linearLayoutManager);
        adapter = new ModelDataAdapter();
        rv_main.setAdapter(adapter);
        adapter.setModelData(mockDatas);
    }

    private List<ModelData> generateDatas() {
        ArrayList<ModelData> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ModelData data = new ModelData(Constants.EASY, "头部第" + i);
            datas.add(data);
        }
        for (int i = 0; i < 10; i++) {
            ModelData data = new ModelData(Constants.HARD, "中部第" + i);
            List<ModelData.SubData> subData = new ArrayList<>(10);
            for (int j = 0; j < 10; j++) {
                ModelData.SubData tmp = new ModelData.SubData();
                tmp.setSubImgUrl("https://b-ssl.duitang.com/uploads/item/201411/28/20141128094709_XtzxV.jpeg");
                tmp.setSubTitle("Sub--" + i + "--" + j);
                subData.add(tmp);
            }
            data.setSubdatas(subData);
            datas.add(data);
        }
        for (int i = 0; i < 10; i++) {
            ModelData data = new ModelData(Constants.EASY, "尾部第" + i);
            datas.add(data);
        }
        return datas;
    }

    @OnClick(R.id.btn_update)
    public void click(View view) {
        position++;
        if (position > size -1) {
            position = 0;
        }

        /*
        Log.d("Solarex", "update " + position);
//        adapter.setModelData(mockDatas);
        rv_main.post(new Runnable() {
            @Override
            public void run() {
                adapter.setModelDataOnly(mockDatas);
//                rv_main.setAdapter(adapter);
                adapter.notifyItemChanged(position, new Object());
            }
        });
        */
        SecondActivity.goSecondActivity(this, position);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 0) {
            int position = data.getIntExtra(SecondActivity.KEY_PARAMS, 0);
            rv_main.scrollToPosition(position);
            Log.d("Solarex", "update position = " + position);
            adapter.notifyItemChanged(position, new Object());
        }
    }
}
