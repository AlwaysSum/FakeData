package com.maguangcan.fake.example;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.maguangcan.fake.FakeDataUtils;
import com.maguangcan.fake.example.bean.TestFake;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化数据
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RecyclerView recyclerView = findViewById(R.id.recyView);
        final MainAdapter adapter = new MainAdapter(FakeDataUtils.fakeList(TestFake.class, 30));
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "数据切换~", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                adapter.setNewDatas(FakeDataUtils.fakeList(TestFake.class, 30));
            }
        });


    }
}
