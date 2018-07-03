package com.solarexsoft.recyclerviewnestedrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_main)
    RecyclerView rv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        List<ModelData> mockDatas = generateDatas();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        rv_main.setLayoutManager(linearLayoutManager);
        ModelDataAdapter adapter = new ModelDataAdapter();
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
}
