package cn.surine.weatherreport.Mvp.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.surine.weatherreport.Mvp.Bean.Forecast;
import cn.surine.weatherreport.R;

/**
 * Created by Surine on 2018/12/25.
 */

public class WeatherListAdapter extends BaseQuickAdapter<Forecast,BaseViewHolder>{
    public WeatherListAdapter(int layoutResId, @Nullable List<Forecast> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Forecast item) {
         helper.setText(R.id.textView3,item.getDate());
         helper.setText(R.id.textView4,item.getFengxiang());
         helper.setText(R.id.textView5,item.getLow()+"-"+item.getHigh());
         if(item.getType().equals("晴")){
             helper.setImageResource(R.id.imageView,R.drawable.sun);
         }else if(item.getType().equals("多云")){
             helper.setImageResource(R.id.imageView,R.drawable.cloudy);
         }else if(item.getType().equals("阴")){
             helper.setImageResource(R.id.imageView,R.drawable.yintian);
         }
    }
}
