package sample;

import java.util.Arrays;

public class WeatherData {
    float latCord, longCord;
    String city;// место
    String weather_Type_Image;// тип погоды(картинка)
    String temperature;
    String feels_Like;
    String current_Time;// текущее время
    String humidity;// влажность
    String wind;// ветер
    String pressure;// давление
    String[] hours;// часы на данный момент
    String[] hours_weather_Type_Images;// картинки по часам на данный момент
    String[] hours_Temperatures;// температура по часам на данный момент
    String[] dates;// даты на данный момент
    String[] dates_Day_of_Week;// дни недели
    String[] dates_weather_Type_Images;// картинки по датам на данный момент
    String[] dates_Temperatures_Day;// температура по датам днем
    String[] dates_Temperatures_Night;// температура по датам ночью


    public WeatherData() {
        this.latCord = 0;
        this.longCord = 0;
        this.city = "Москва";
        this.weather_Type_Image = "-";
        this.temperature = "-";
        this.feels_Like = "-";
        this.current_Time = "-";
        this.humidity = "-";
        this.wind = "-";
        this.pressure = "-";
        this.hours = new String[8];
        this.hours_weather_Type_Images = new String[8];
        this.hours_Temperatures = new String[8];
        this.dates = new String[8];
        this.dates_weather_Type_Images = new String[8];
        this.dates_Temperatures_Day = new String[8];
        this.dates_Temperatures_Night = new String[8];
        this.dates_Day_of_Week = new String[8];
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "latCord=" + latCord +
                ", longCord=" + longCord +
                ", city='" + city + '\'' +
                ", weather_Type_Image='" + weather_Type_Image + '\'' +
                ", temperature=" + temperature +
                ", feels_Like=" + feels_Like +
                ", current_Time='" + current_Time + '\'' +
                ", humidity='" + humidity + '\'' +
                ", wind='" + wind + '\'' +
                ", pressure='" + pressure + '\'' +
                ", hours=" + Arrays.toString(hours) +
                ", hours_weather_Type_Images=" + Arrays.toString(hours_weather_Type_Images) +
                ", hours_Temperatures=" + Arrays.toString(hours_Temperatures) +
                ", dates=" + Arrays.toString(dates) +
                ", dates_Day_of_Week=" + Arrays.toString(dates_Day_of_Week) +
                ", dates_Temperatures_Day=" + Arrays.toString(dates_Temperatures_Day) +
                ", dates_Temperatures_Night=" + Arrays.toString(dates_Temperatures_Night) +
                ", dates_weather_Type_Images=" + Arrays.toString(dates_weather_Type_Images) +
                '}';
    }
}
