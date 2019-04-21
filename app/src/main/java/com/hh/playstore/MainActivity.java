package com.hh.playstore;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hh.playstore.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import datas.App;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding act;
    List<App> appList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fillApps();



    }

    void fillApps(){
        appList.add(new App(1, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(2, "MineCraft - Pocket Edition", "Mojang", 4, 5000, true));
        appList.add(new App(3, "아스팔트 7: 하트", "GameLoft", 2, 1000, false));
        appList.add(new App(4, "팔라독(Paladog)", "FazeCat", 3, 1087, false));
        appList.add(new App(5, "Plants Vs. Zombies", "EA Swiss Sarl", 1, 2000, false));
        appList.add(new App(6, "스왐피(Swampy)", "Disney", 4, 3000, false));


    }



}
