package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hh.playstore.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import datas.App;

public class AppAdapter extends ArrayAdapter<App> {

    Context mContext;
    List<App> mList;
    LayoutInflater inf;


    public AppAdapter(Context context, List<App> list) {

        super(context, R.layout.app_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null){
            row = inf.inflate(R.layout.app_list_item, null);

        }

        App appData =mList.get(position);

        TextView titleTxt = row.findViewById(R.id.titleTxt);
        TextView companyTxt = row.findViewById(R.id.companyTxt);
        TextView installYn = row.findViewById(R.id.installYn);


        ImageView star1 = row.findViewById(R.id.star1);
        ImageView star2 = row.findViewById(R.id.star2);
        ImageView star3 = row.findViewById(R.id.star3);
        ImageView star4 = row.findViewById(R.id.star4);
        ImageView star5 = row.findViewById(R.id.star5);


        /*if(appData.userRating == 1){
            star1.setImageResource(R.drawable.star_fill);
            star2.setImageResource(R.drawable.star_empty);
            star3.setImageResource(R.drawable.star_empty);
            star4.setImageResource(R.drawable.star_empty);
            star5.setImageResource(R.drawable.star_empty);
        }*/

        List<ImageView> stars = new ArrayList<>();
        stars.add(star1);
        stars.add(star2);
        stars.add(star3);
        stars.add(star4);
        stars.add(star5);

        /* 초기화 */
        for (ImageView star : stars){
            star.setImageResource(R.drawable.star_empty);
            //stars.get(i).setImageResource(R.drawable.star_fill);
        }


        for (int i = 0 ; i< appData.userRating ; i++){
            stars.get(i).setImageResource(R.drawable.star_fill);
        }






        titleTxt.setText(String.format("%d. %s", appData.rank, appData.title));
        companyTxt.setText(appData.companyName);

        /*설치되었다면, 가격을 띄워줌. 3,000원의 양식*/

        if (appData.isMine){
            installYn.setText(String.format("설치된 항목"));


        }else
        {
            installYn.setText(String.format("%,d원", appData.price));

        }






        return row;
    }
}

