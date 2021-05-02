package org.example;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import org.json.*;

/**
 * Класс контроллера окна
 *
 * @author Кирилл Аксенов и Владимир Майоров
 * @version 1.0
 */

public class Controller {

    /**
     * Поля с id элементов из sample.fxml
     */
    @FXML
    private Text city;

    @FXML
    private Text current_Temperature;

    @FXML
    private Text current_Time;

    @FXML
    private Text current_Humidity;

    @FXML
    private Text current_Wind;

    @FXML
    private Text current_Pressure;

    @FXML
    private ImageView current_Weather_Image;

    @FXML
    private Text current_Feels_Like;

    @FXML
    private Button edit_Button;

    @FXML
    private Button refresh_Button;

    @FXML
    private Text hours0;

    @FXML
    private ImageView hours_Image0;

    @FXML
    private Text hours_Temperature0;

    @FXML
    private Text hours01;

    @FXML
    private ImageView hours_Image01;

    @FXML
    private Text hours_Temperature01;

    @FXML
    private Text hours011;

    @FXML
    private ImageView hours_Image011;

    @FXML
    private Text hours_Temperature011;

    @FXML
    private Text hours012;

    @FXML
    private ImageView hours_Image012;

    @FXML
    private Text hours_Temperature012;

    @FXML
    private Text hours013;

    @FXML
    private ImageView hours_Image013;

    @FXML
    private Text hours_Temperature013;

    @FXML
    private Text hours014;

    @FXML
    private ImageView hours_Image014;

    @FXML
    private Text hours_Temperature014;

    @FXML
    private Text hours015;

    @FXML
    private ImageView hours_Image015;

    @FXML
    private Text hours_Temperature015;

    @FXML
    private Text hours016;

    @FXML
    private ImageView hours_Image016;

    @FXML
    private Text hours_Temperature016;

    @FXML
    private Text dates_Day_of_Week0;

    @FXML
    private Text dates0;

    @FXML
    private ImageView dates_Image0;

    @FXML
    private Text dates_Temperatures_Day0;

    @FXML
    private Text dates_Temperatures_Night0;

    @FXML
    private Text dates_Day_of_Week01;

    @FXML
    private Text dates01;

    @FXML
    private ImageView dates_Image01;

    @FXML
    private Text dates_Temperatures_Day01;

    @FXML
    private Text dates_Temperatures_Night01;

    @FXML
    private Text dates_Day_of_Week011;

    @FXML
    private Text dates011;

    @FXML
    private ImageView dates_Image011;

    @FXML
    private Text dates_Temperatures_Day011;

    @FXML
    private Text dates_Temperatures_Night011;

    @FXML
    private Text dates_Day_of_Week012;

    @FXML
    private Text dates012;

    @FXML
    private ImageView dates_Image012;

    @FXML
    private Text dates_Temperatures_Day012;

    @FXML
    private Text dates_Temperatures_Night012;

    @FXML
    private Text dates_Day_of_Week013;

    @FXML
    private Text dates013;

    @FXML
    private ImageView dates_Image013;

    @FXML
    private Text dates_Temperatures_Day013;

    @FXML
    private Text dates_Temperatures_Night013;

    @FXML
    private Text dates_Day_of_Week014;

    @FXML
    private Text dates014;

    @FXML
    private ImageView dates_Image014;

    @FXML
    private Text dates_Temperatures_Day014;

    @FXML
    private Text dates_Temperatures_Night014;

    @FXML
    private Text dates_Day_of_Week015;

    @FXML
    private Text dates015;

    @FXML
    private ImageView dates_Image015;

    @FXML
    private Text dates_Temperatures_Day015;

    @FXML
    private Text dates_Temperatures_Night015;

    @FXML
    private Text dates_Day_of_Week016;

    @FXML
    private Text dates016;

    @FXML
    private ImageView dates_Image016;

    @FXML
    private Text dates_Temperatures_Day016;

    @FXML
    private Text dates_Temperatures_Night016;

    /**
     * Поле данных погоды
     */
    public WeatherData weatherData1 = new WeatherData();

    /**
     * Функция создания окна ввода текста
     *
     * @param s - текущий город
     * @return output - возвращает введенное значение
     */
    public String createInputDialog(String s) {
        String output = null;
        TextInputDialog dialog = new TextInputDialog(s);
        dialog.setTitle("Введите город");
        dialog.setHeaderText("");
        dialog.setContentText("Введите город или адрес:");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            output = result.get();
        }
        return output;
    }

    /**
     * Процедура создания окна ошибки
     *
     * @param massage - сообщение с ошибкой
     */
    public void createErrorDialog(String massage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText(massage);
        alert.showAndWait();
    }

    /**
     * Процедура создания окна ошибки с исключением
     *
     * @param massage - сообщение с ошибкой
     * @param e       - сообщение исключения
     */
    public void creteExceptionDialog(Exception e, String massage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("");
        alert.setContentText(massage);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

    /**
     * Процедура инициализации окна приложения
     */
    @FXML
    void initialize() {
        weatherData1.city = "Москва";
        loadDataToWeatherData(weatherData1, "Москва");
        drawWeather(weatherData1);

        edit_Button.setOnAction(event -> {
            if (weatherData1.city == null) {
                weatherData1.city = createInputDialog("");
            } else {
                weatherData1.city = createInputDialog(weatherData1.city);
            }
            loadDataToWeatherData(weatherData1, weatherData1.city);
            drawWeather(weatherData1);
        });

        refresh_Button.setOnAction(event -> {
            loadDataToWeatherData(weatherData1, weatherData1.city);
            drawWeather(weatherData1);
        });
    }

    /**
     * Процедура загрузки данных в класс погоды
     *
     * @param weatherData - в какой класс загружать
     * @param city        - данные о каком городе загружать
     */
    public void loadDataToWeatherData(WeatherData weatherData, String city) {
        city = city.replaceAll(" ", "%20");
        String latLongJson = getUrlContentLatLng("https://maps.googleapis.com/maps/api/geocode/json?address=" + city + "&language=ru&key=AIzaSyB2s7qxSAbtcJYrP7anzjrT9SjODKNMBWQ");
        parseLatLongJson(latLongJson, weatherData);
        String weatherJson = getUrlContentWeather("https://api.openweathermap.org/data/2.5/onecall?lat=" + weatherData.latCord + "&lon=" + weatherData.longCord + "&exclude=minutely,alerts&units=metric&appid=65a905f558f9f4a582c496c9bd139cda");
        parseWeatherJson(weatherJson, weatherData);
    }

    /**
     * Функция преобразования milliseconds в время
     *
     * @param unixSeconds - миллисекунды для преобразования
     */
    public String getTimeFromUnits(int unixSeconds) {
        Date date = new Date(unixSeconds * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        return sdf.format(date);
    }

    /**
     * Функция преобразования milliseconds в дату
     *
     * @param unixSeconds - миллисекунды для преобразования
     */
    public String getDateFromUnits(int unixSeconds) {
        Date date = new Date(unixSeconds * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        sdf1.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        String month = sdf.format(date), day = sdf1.format(date);
        if (day.charAt(0) == '0') {
            day = day.substring(1);
        }
        switch (month) {
            case "01":
                month = "янв";
                break;
            case "02":
                month = "фев";
                break;
            case "03":
                month = "мар";
                break;
            case "04":
                month = "апр";
                break;
            case "05":
                month = "мая";
                break;
            case "06":
                month = "июня";
                break;
            case "07":
                month = "июля";
                break;
            case "08":
                month = "авг";
                break;
            case "09":
                month = "сен";
                break;
            case "10":
                month = "окт";
                break;
            case "11":
                month = "ноя";
                break;
            case "12":
                month = "дек";
                break;
            default:
                break;
        }
        return day + " " + month;
    }

    /**
     * Функция преобразования milliseconds в день недели
     *
     * @param unixSeconds - миллисекунды для преобразования
     */
    public String getDayOfWeekFromUnits(int unixSeconds) {
        Date date = new Date(unixSeconds * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        String formattedDate = sdf.format(date);

        Date dt1 = null;
        try {
            dt1 = sdf.parse(formattedDate);
        } catch (Exception e) {
            createErrorDialog("Ошибка при преобразовании units в день недели.");
        }

        DateFormat format2 = new SimpleDateFormat("EEE");
        String day = format2.format(dt1);
        String finalDay = day.substring(0, 1).toUpperCase() + day.substring(1);
        switch (finalDay) {
            case "Mon":
                finalDay = "Пн";
                break;
            case "Tue":
                finalDay = "Вт";
                break;
            case "Wed":
                finalDay = "Ср";
                break;
            case "Thu":
                finalDay = "Чт";
                break;
            case "Fri":
                finalDay = "Пт";
                break;
            case "Sat":
                finalDay = "Сб";
                break;
            case "Sun":
                finalDay = "Вс";
                break;
            default:
                break;
        }
        return finalDay;
    }

    /**
     * Функция запроса и получения данных о погоде
     *
     * @param urlAddress - адресс, по которому запрашивать погоду
     * @return content.toString() - данные о погоде в формате json
     */
    public String getUrlContentWeather(String urlAddress) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urlAddress);
            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            creteExceptionDialog(e, "Ошибка при обращении к OpenWeather API.");
        }
        return content.toString();
    }

    /**
     * Функция запроса и получения данных о координатах
     *
     * @param urlAddress - адресс, по которому запрашивать координаты
     * @return content.toString() - данные о координатах в формате json
     */
    public String getUrlContentLatLng(String urlAddress) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urlAddress);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            //InputStreamReader r=new InputStreamReader(urlConnection.getInputStream(), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

//            DataOutputStream tmpStream = new DataOutputStream(connection.getOutputStream());
//            BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(tmpStream, "UTF-8"));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            creteExceptionDialog(e, "Ошибка при обращении к Geocoding API.");
        }
        return content.toString();
    }

    /**
     * Процедура записи данных о координатах из json'а в класс данных о погоде
     *
     * @param inputJson   - json для парсинга
     * @param weatherData - класс погоды, куда записывать данные
     */
    public void parseLatLongJson(String inputJson, WeatherData weatherData) {
        try {
            if (!inputJson.isEmpty()) {
                JSONObject latLongJson = new JSONObject(inputJson);
                weatherData.latCord = latLongJson.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getFloat("lat");
                weatherData.longCord = latLongJson.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getFloat("lng");
                weatherData.city = latLongJson.getJSONArray("results").getJSONObject(0).getString("formatted_address")/*.getJSONArray("address_components").getJSONObject(0).getString("long_name")*/;
            } else {
                createErrorDialog("Ошибка, latLongJSON пуст!");
            }
        } catch (Exception e) {
            createErrorDialog("Ошибка при определении координат, скорее всего город введен неверно.");
        }
    }

    /**
     * Процедура записи данных о погоде из json'а в класс данных о погоде
     *
     * @param inputJson   - json для парсинга
     * @param weatherData - класс погоды, куда записывать данные
     */
    public void parseWeatherJson(String inputJson, WeatherData weatherData) {
        try {
            if (!inputJson.isEmpty()) {
                JSONObject weatherJson = new JSONObject(inputJson);
                weatherData.current_Time = "Сейчас " + getTimeFromUnits(weatherJson.getJSONObject("current").getInt("dt"));
                weatherData.temperature = Math.round(weatherJson.getJSONObject("current").getFloat("temp")) + "°C";
                weatherData.feels_Like = Math.round(weatherJson.getJSONObject("current").getFloat("feels_like")) + "°C";
                weatherData.humidity = weatherJson.getJSONObject("current").getInt("humidity") + " %";
                weatherData.wind = weatherJson.getJSONObject("current").getFloat("wind_speed") + " м/с";
                weatherData.pressure = (int) (weatherJson.getJSONObject("current").getFloat("pressure") * 0.750062) + " мм рт. ст.";
                weatherData.weather_Type_Image = weatherJson.getJSONObject("current").getJSONArray("weather").getJSONObject(0).getString("icon") + ".png";
                for (int i = 0; i < weatherData.hours.length; i++) {
                    weatherData.hours[i] = getTimeFromUnits(weatherJson.getJSONArray("hourly").getJSONObject(i + 1).getInt("dt"));
                    weatherData.hours_weather_Type_Images[i] = weatherJson.getJSONArray("hourly").getJSONObject(i + 1).getJSONArray("weather").getJSONObject(0).getString("icon") + ".png";
                    weatherData.hours_Temperatures[i] = Math.round(weatherJson.getJSONArray("hourly").getJSONObject(i + 1).getFloat("temp")) + "°C";
                }
                for (int i = 0; i < weatherData.dates.length; i++) {
                    weatherData.dates[i] = getDateFromUnits(weatherJson.getJSONArray("daily").getJSONObject(i).getInt("dt"));
                    weatherData.dates_Day_of_Week[i] = getDayOfWeekFromUnits(weatherJson.getJSONArray("daily").getJSONObject(i).getInt("dt"));
                    weatherData.dates_weather_Type_Images[i] = weatherJson.getJSONArray("daily").getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("icon") + ".png";
                    weatherData.dates_Temperatures_Day[i] = Math.round(weatherJson.getJSONArray("daily").getJSONObject(i).getJSONObject("temp").getFloat("day")) + "°C";
                    weatherData.dates_Temperatures_Night[i] = Math.round(weatherJson.getJSONArray("daily").getJSONObject(i).getJSONObject("temp").getFloat("night")) + "°C";
                }
                weatherData.dates_Day_of_Week[0] = "Сегодня";
                weatherData.dates_Temperatures_Day[0] = "днём " + weatherData.dates_Temperatures_Day[0];
                weatherData.dates_Temperatures_Night[0] = "ночью " + weatherData.dates_Temperatures_Night[0];
            } else {
                createErrorDialog("Ошибка, weatherJSON пуст!");
            }
        } catch (Exception e) {
            createErrorDialog("Ошибка при записи данных погоды, скорее всего для этих координат невозможно определить погоду.");
        }
    }

    /**
     * Процедура отрисовки погоды на экран
     *
     * @param weatherDataForDrawing - данные о погоде, которые отрисовывать
     */
    public void drawWeather(WeatherData weatherDataForDrawing) {
        city.setText(weatherDataForDrawing.city);
        current_Temperature.setText(weatherDataForDrawing.temperature);
        current_Time.setText(weatherDataForDrawing.current_Time);
        current_Humidity.setText("Влажность: " + weatherDataForDrawing.humidity);
        current_Wind.setText("Ветер: " + weatherDataForDrawing.wind);
        current_Pressure.setText("Давление: " + weatherDataForDrawing.pressure);
        current_Feels_Like.setText("Ощущается как " + weatherDataForDrawing.feels_Like);
        current_Weather_Image.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.weather_Type_Image))));


        hours0.setText(weatherDataForDrawing.hours[0]);
        hours_Image0.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.hours_weather_Type_Images[0]))));
        hours_Temperature0.setText(weatherDataForDrawing.hours_Temperatures[0]);

        hours01.setText(weatherDataForDrawing.hours[1]);
        hours_Image01.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.hours_weather_Type_Images[1]))));
        hours_Temperature01.setText(weatherDataForDrawing.hours_Temperatures[1]);

        hours011.setText(weatherDataForDrawing.hours[2]);
        hours_Image011.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.hours_weather_Type_Images[2]))));
        hours_Temperature011.setText(weatherDataForDrawing.hours_Temperatures[2]);

        hours012.setText(weatherDataForDrawing.hours[3]);
        hours_Image012.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.hours_weather_Type_Images[3]))));
        hours_Temperature012.setText(weatherDataForDrawing.hours_Temperatures[3]);

        hours013.setText(weatherDataForDrawing.hours[4]);
        hours_Image013.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.hours_weather_Type_Images[4]))));
        hours_Temperature013.setText(weatherDataForDrawing.hours_Temperatures[4]);

        hours014.setText(weatherDataForDrawing.hours[5]);
        hours_Image014.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.hours_weather_Type_Images[5]))));
        hours_Temperature014.setText(weatherDataForDrawing.hours_Temperatures[5]);

        hours015.setText(weatherDataForDrawing.hours[6]);
        hours_Image015.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.hours_weather_Type_Images[6]))));
        hours_Temperature015.setText(weatherDataForDrawing.hours_Temperatures[6]);

        hours016.setText(weatherDataForDrawing.hours[7]);
        hours_Image016.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.hours_weather_Type_Images[7]))));
        hours_Temperature016.setText(weatherDataForDrawing.hours_Temperatures[7]);


        dates_Day_of_Week0.setText(weatherDataForDrawing.dates_Day_of_Week[0]);
        dates0.setText(weatherDataForDrawing.dates[0]);
        dates_Image0.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.dates_weather_Type_Images[0]))));
        dates_Temperatures_Day0.setText(weatherDataForDrawing.dates_Temperatures_Day[0]);
        dates_Temperatures_Night0.setText(weatherDataForDrawing.dates_Temperatures_Night[0]);

        dates_Day_of_Week01.setText(weatherDataForDrawing.dates_Day_of_Week[1]);
        dates01.setText(weatherDataForDrawing.dates[1]);
        dates_Image01.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.dates_weather_Type_Images[1]))));
        dates_Temperatures_Day01.setText(weatherDataForDrawing.dates_Temperatures_Day[1]);
        dates_Temperatures_Night01.setText(weatherDataForDrawing.dates_Temperatures_Night[1]);

        dates_Day_of_Week011.setText(weatherDataForDrawing.dates_Day_of_Week[2]);
        dates011.setText(weatherDataForDrawing.dates[2]);
        dates_Image011.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.dates_weather_Type_Images[2]))));
        dates_Temperatures_Day011.setText(weatherDataForDrawing.dates_Temperatures_Day[2]);
        dates_Temperatures_Night011.setText(weatherDataForDrawing.dates_Temperatures_Night[2]);

        dates_Day_of_Week012.setText(weatherDataForDrawing.dates_Day_of_Week[3]);
        dates012.setText(weatherDataForDrawing.dates[3]);
        dates_Image012.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.dates_weather_Type_Images[3]))));
        dates_Temperatures_Day012.setText(weatherDataForDrawing.dates_Temperatures_Day[3]);
        dates_Temperatures_Night012.setText(weatherDataForDrawing.dates_Temperatures_Night[3]);

        dates_Day_of_Week013.setText(weatherDataForDrawing.dates_Day_of_Week[4]);
        dates013.setText(weatherDataForDrawing.dates[4]);
        dates_Image013.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.dates_weather_Type_Images[4]))));
        dates_Temperatures_Day013.setText(weatherDataForDrawing.dates_Temperatures_Day[4]);
        dates_Temperatures_Night013.setText(weatherDataForDrawing.dates_Temperatures_Night[4]);

        dates_Day_of_Week014.setText(weatherDataForDrawing.dates_Day_of_Week[5]);
        dates014.setText(weatherDataForDrawing.dates[5]);
        dates_Image014.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.dates_weather_Type_Images[5]))));
        dates_Temperatures_Day014.setText(weatherDataForDrawing.dates_Temperatures_Day[5]);
        dates_Temperatures_Night014.setText(weatherDataForDrawing.dates_Temperatures_Night[5]);

        dates_Day_of_Week015.setText(weatherDataForDrawing.dates_Day_of_Week[6]);
        dates015.setText(weatherDataForDrawing.dates[6]);
        dates_Image015.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.dates_weather_Type_Images[6]))));
        dates_Temperatures_Day015.setText(weatherDataForDrawing.dates_Temperatures_Day[6]);
        dates_Temperatures_Night015.setText(weatherDataForDrawing.dates_Temperatures_Night[6]);

        dates_Day_of_Week016.setText(weatherDataForDrawing.dates_Day_of_Week[7]);
        dates016.setText(weatherDataForDrawing.dates[7]);
        dates_Image016.setImage(new javafx.scene.image.Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + weatherDataForDrawing.dates_weather_Type_Images[7]))));
        dates_Temperatures_Day016.setText(weatherDataForDrawing.dates_Temperatures_Day[7]);
        dates_Temperatures_Night016.setText(weatherDataForDrawing.dates_Temperatures_Night[7]);
    }
}
