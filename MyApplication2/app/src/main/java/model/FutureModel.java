package model;

/**
 * Created by 1305235 on 2017/3/23.
 */

public class FutureModel {
    private String temperature;/*": "9℃~13℃",*/
    private String weather;/*": "阴转小雨",*/
    private String weather_id;
    private String wind;/*": "北风微风",*/
    private String week;/*": "星期四",*/
    private String date;/*": "20170323"*/

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(String weather_id) {
        this.weather_id = weather_id;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FutureModel{" +
                "temperature='" + temperature + '\'' +
                ", weather='" + weather + '\'' +
                ", weather_id='" + weather_id + '\'' +
                ", wind='" + wind + '\'' +
                ", week='" + week + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
