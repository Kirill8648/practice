package sample;

import java.util.Arrays;

/**
 * Класс с данными погоды
 *
 * @author Кирилл Аксенов и Владимир Майоров
 * @version 1.0
 */

public class WeatherData {
    /**
     * Поля координат
     */
    float latCord, longCord;
    /**
     * Поле места
     */
    String city;
    /**
     * Поле названия картинки погоды
     */
    String weather_Type_Image;
    /**
     * Поле температуры
     */
    String temperature;
    /**
     * Поле чувствуется как
     */
    String feels_Like;
    /**
     * Поле текущее время
     */
    String current_Time;
    /**
     * Поле влажность
     */
    String humidity;
    /**
     * Поле ветер
     */
    String wind;
    /**
     * Поле давление
     */
    String pressure;
    /**
     * Поле массив ближайших девяти часов
     */
    String[] hours;
    /**
     * Поле массив названий картинок погоды по часам
     */
    String[] hours_weather_Type_Images;
    /**
     * Поле массив температур по часам
     */
    String[] hours_Temperatures;
    /**
     * Поле массив дат на ближайшую неделю
     */
    String[] dates;// даты на данный момент
    /**
     * Поле массив дней недели на ближайшую неделю
     */
    String[] dates_Day_of_Week;
    /**
     * Поле массив картинок погоды на ближайшую неделю
     */
    String[] dates_weather_Type_Images;
    /**
     * Поле массив температур днем на ближайшую неделю
     */
    String[] dates_Temperatures_Day;
    /**
     * Поле массив температур ночью на ближайшую неделю
     */
    String[] dates_Temperatures_Night;


    /**
     * Конструктор - инициализация класса с пустыми значениями
     */

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

    /**
     * Функция вывода полей класса в консоль
     *
     * @return возвращает строку с значениями всех полей класса
     */

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
