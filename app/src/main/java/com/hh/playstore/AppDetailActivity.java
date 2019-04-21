package com.hh.playstore;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.view.View;

import com.hh.playstore.databinding.ActivityAppDetailBinding;
import com.hh.playstore.databinding.ActivityMainBinding;

import datas.App;

public class AppDetailActivity extends AppCompatActivity {

    //AppDetailActivity act;
    ActivityAppDetailBinding act;

    App mAppData; // 이 화면에서 다룰 앱의 정보를 가진 멤버변수


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_app_detail);
        //act = DataBindingUtil.setContentView(this, R.layout.activity_app_detail);
        act = DataBindingUtil.setContentView(this,R.layout.activity_app_detail);

        /*String appTitle = getIntent().getStringExtra("제목");
        String companyNmae = getIntent().getStringExtra("회사");*/

        mAppData = (App) getIntent().getSerializableExtra("앱정보");



        act.appTitle.setText(mAppData.title);
        act.companyTitle.setText(mAppData.companyName);

        act.userRankingTxt.setText(String.format("%d점 ",  mAppData.userRating));

        if(mAppData.isMine){
            act.removeBtn.setVisibility(View.VISIBLE);
            act.launchBtn.setVisibility(View.VISIBLE);
            act.purchaseBtn.setVisibility(View.GONE);
        }else{
            act.removeBtn.setVisibility(View.GONE);
            act.launchBtn.setVisibility(View.GONE);
            act.purchaseBtn.setVisibility(View.VISIBLE);

            // 구매히기 버튼의 문구도 올바른 가격으로
            act.purchaseBtn.setText(String.format("구매하기(%,d원)", mAppData.price));

        }



        act.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri phoneUri = Uri.parse("tel:01071265530");
                Intent intent = new Intent(Intent.ACTION_DIAL, phoneUri);
                startActivity(intent);

            }
        });











    }
}
