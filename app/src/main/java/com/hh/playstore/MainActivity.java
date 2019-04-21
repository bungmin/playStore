package com.hh.playstore;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.hh.playstore.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import Adapter.AppAdapter;
import datas.App;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding act;
    List<App> appList = new ArrayList<>();
    AppAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fillApps();

        mAdapter = new AppAdapter(MainActivity.this, appList);
        act.appRankList.setAdapter(mAdapter);

        act.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"확인버튼을 눌렀습니다.", Toast.LENGTH_SHORT ).show();



            }
        });

        act.appRankList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Toast.makeText(MainActivity.this,String.format("%d번 줄 클릭", i), Toast.LENGTH_SHORT ).show();

                App clickedAppData  =appList.get(i);
                Intent intent = new Intent(MainActivity.this, AppDetailActivity.class);
                intent.putExtra("제목", clickedAppData.title);
                intent.putExtra("회사", clickedAppData.companyName);

                intent.putExtra("앱정보", clickedAppData);
                startActivity(intent);
            }
        });

        act.appRankList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Toast.makeText(MainActivity.this,String.format("%d번 줄 클릭222", i), Toast.LENGTH_SHORT ).show();

                appList.remove(i);
                mAdapter.notifyDataSetChanged();



                return true;
            }
        });



    }

    void fillApps(){
        /*appList.add(new App(1, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(2, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(3, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(4, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(5, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(6, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));*/


        appList.add(new App(1, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(2, "MineCraft - Pocket Edition", "Mojang", 4, 5000, true));
        appList.add(new App(3, "아스팔트 7: 하트", "GameLoft", 2, 1000, false));
        appList.add(new App(4, "팔라독(Paladog)", "FazeCat", 3, 1087, false));
        appList.add(new App(5, "Plants Vs. Zombies", "EA Swiss Sarl", 1, 2000, false));
        appList.add(new App(6, "스왐피(Swampy)", "Disney", 4, 3000, false));


    }



}
