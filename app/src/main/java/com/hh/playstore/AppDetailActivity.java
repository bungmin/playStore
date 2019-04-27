package com.hh.playstore;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.hh.playstore.databinding.ActivityAppDetailBinding;
import com.hh.playstore.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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


        act.dateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("텍스트뷰 클릭!", "실제로 동작하나?");

                DatePickerDialog dpd = new DatePickerDialog(AppDetailActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        Toast.makeText(AppDetailActivity.this,String.format("%d, %d, %d",  i,i1,i2), Toast.LENGTH_SHORT ).show();

                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.YEAR, i);
                        cal.set(Calendar.MONTH, i1);
                        cal.set(Calendar.DAY_OF_MONTH, i2);


                        cal.set(i, i1, i2);

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일");
                        String dateStr = sdf.format(cal.getTimeInMillis());

                        act.dateTxt.setText(dateStr);





                    }
                }, 2019, 3, 27);

                dpd.show();
            }
        });

        act.timeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog tpd = new TimePickerDialog(AppDetailActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.HOUR_OF_DAY, i);
                        cal.set(Calendar.MINUTE, i1);

                        SimpleDateFormat sdf = new SimpleDateFormat("a h시 M분", Locale.KOREA);
                        String timeStr = sdf.format(cal.getTimeInMillis());

                        act.timeTxt.setText(timeStr);

                    }
                }, 15,15,false);

                tpd.show();




            }


        });











    }
}
