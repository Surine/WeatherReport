package cn.surine.weatherreport.Mvp.Main;

import cn.surine.weatherreport.Mvp.base.BaseView;

/**
 * Created by Surine on 2018/9/2.
 * MVP：界面接口
 */

public interface WeatherView<V> extends BaseView {

    /**
     * 数据请求成功
     * @param data 请求的数据
     * */
    void showData(V data);

}
