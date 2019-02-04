package cn.surine.weatherreport.Mvp.Main;


import cn.surine.weatherreport.Mvp.base.BaseCallBack;

/**
 * Created by Surine on 2018/9/2.
 */

public interface WeatherModel {
    void getWeatherInfo(String city,BaseCallBack<String> baseCallBack);
}
