package cn.surine.weatherreport.Mvp.Bean;

import org.litepal.crud.DataSupport;

/**
 * Created by Surine on 2018/12/26.
 */

public class CityLove extends DataSupport{
    private int id;
    private String cityName;

    public CityLove(int id, String cityName) {
        this.id = id;
        this.cityName = cityName;
    }

    public CityLove() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
