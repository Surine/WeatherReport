package cn.surine.weatherreport.Mvp.Bean;

import java.util.List;

/**
 * Created by Surine on 2018/12/25.
 */

public class WeatherBean {
   private String aqi;
   private String city;
   private String ganmao;
   private String wendu;
   private List<Forecast> forecast;

    @Override
    public String toString() {
        return "WeatherBean{" +
                "aqi='" + aqi + '\'' +
                ", item_city='" + city + '\'' +
                ", ganmao='" + ganmao + '\'' +
                ", wendu='" + wendu + '\'' +
                ", list=" + forecast +
                '}';
    }

    public WeatherBean() {
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }
}
