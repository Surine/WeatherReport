package cn.surine.weatherreport.Mvp.Main;

import android.content.Context;
import android.content.res.Resources;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.surine.weatherreport.Data.Data;
import cn.surine.weatherreport.Mvp.base.BaseCallBack;
import cn.surine.weatherreport.Util.HttpUtil;
import cn.surine.weatherreport.Util.LogUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Surine on 2018/9/2.
 * mvp:loginmodel
 */

public class WeatherImpl implements WeatherModel {
    private final String TAG = this.getClass().getName();
    private Context context;
    private Resources r;
    private int tag = 0;


    public WeatherImpl(Context context) {
        this.context = context;
        r = context.getResources();
    }


    @Override
    public void getWeatherInfo(String city, final BaseCallBack<String> baseCallBack) {
        HttpUtil.get(Data.API+city).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //baseCallBack.onFail(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    baseCallBack.onSuccess(jsonObject.getString("data"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                baseCallBack.onSuccess("");
            }
        });
    }
}





