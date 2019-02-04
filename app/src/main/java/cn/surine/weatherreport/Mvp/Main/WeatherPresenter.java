package cn.surine.weatherreport.Mvp.Main;

import android.content.Context;
import android.content.res.Resources;

import cn.surine.weatherreport.Mvp.Bean.WeatherBean;
import cn.surine.weatherreport.Mvp.base.BaseCallBack;
import cn.surine.weatherreport.Mvp.base.BasePresenter;
import cn.surine.weatherreport.Util.GsonUtil;

/**
 * Created by Surine on 2018/9/2.
 * Mvp：presenter
 */

public class WeatherPresenter extends BasePresenter<WeatherView> {

    private Resources r;
    private Context context;
    private WeatherImpl weatherImpl;


    public WeatherPresenter(Context context) {
        this.context = context;
        r = context.getResources();
        weatherImpl = new WeatherImpl(context);
    }

    public void getWeatherInfo(String c){
        weatherImpl.getWeatherInfo(c, new BaseCallBack<String>() {
            @Override
            public void onSuccess(String data) {
                if(isViewAttached()){
                    //解析成Weather实体类
                    WeatherBean weatherBean = GsonUtil.parseJsonWithGson(data,WeatherBean.class);
                    getView().showData(weatherBean);
                }
            }

            @Override
            public void onFail(String msg) {
                if(isViewAttached()){
                    getView().showFailMessage(msg);
                }
            }

            @Override
            public void onError() {
                if(isViewAttached()){
                    getView().showErrorMessage();
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
