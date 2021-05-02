package sample;

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

public class Controller {

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

    public WeatherData weatherData1 = new WeatherData();

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

    public void createErrorDialog(String massage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText(massage);
        alert.showAndWait();
    }

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

    @FXML
    void initialize() {
        /*String TEST = new String("Москва").replaceAll(" ", "%20");
        String latLongJson = getUrlContentLatLng("https://maps.googleapis.com/maps/api/geocode/json?address=" + TEST + "&language=ru&key=AIzaSyB2s7qxSAbtcJYrP7anzjrT9SjODKNMBWQ");
        parseLatLongJson(latLongJson, weatherData1);
        //weatherData.toString();
        //String weatherJson = getUrlContentWeather("https://api.openweathermap.org/data/2.5/onecall?lat=" + weatherData1.latCord + "&lon=" + weatherData1.longCord + "&exclude=minutely,alerts&units=metric&appid=65a905f558f9f4a582c496c9bd139cda");
        String weatherJson = "{\"lat\":33.44,\"lon\":-94.04,\"timezone\":\"America/Chicago\",\"timezone_offset\":-18000,\"current\":{\"dt\":1619794365,\"sunrise\":1619782111,\"sunset\":1619830677,\"temp\":18.11,\"feels_like\":17.75,\"pressure\":1022,\"humidity\":68,\"dew_point\":12.12,\"uvi\":1.49,\"clouds\":75,\"visibility\":10000,\"wind_speed\":3.09,\"wind_deg\":70,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]},\"hourly\":[{\"dt\":1619791200,\"temp\":17.77,\"feels_like\":17.48,\"pressure\":1022,\"humidity\":72,\"dew_point\":12.66,\"uvi\":0.7,\"clouds\":80,\"visibility\":10000,\"wind_speed\":3.1,\"wind_deg\":67,\"wind_gust\":10.83,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"pop\":0.57,\"rain\":{\"1h\":0.6}},{\"dt\":1619794800,\"temp\":18.11,\"feels_like\":17.75,\"pressure\":1022,\"humidity\":68,\"dew_point\":12.12,\"uvi\":1.49,\"clouds\":75,\"visibility\":10000,\"wind_speed\":3.41,\"wind_deg\":72,\"wind_gust\":11.38,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"pop\":0.61},{\"dt\":1619798400,\"temp\":18.24,\"feels_like\":18,\"pressure\":1022,\"humidity\":72,\"dew_point\":13.11,\"uvi\":4.22,\"clouds\":80,\"visibility\":10000,\"wind_speed\":4.96,\"wind_deg\":92,\"wind_gust\":11.12,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"pop\":0.57},{\"dt\":1619802000,\"temp\":18.72,\"feels_like\":18.58,\"pressure\":1022,\"humidity\":74,\"dew_point\":14,\"uvi\":5.62,\"clouds\":85,\"visibility\":10000,\"wind_speed\":5.15,\"wind_deg\":92,\"wind_gust\":10.16,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.57},{\"dt\":1619805600,\"temp\":19.57,\"feels_like\":19.54,\"pressure\":1022,\"humidity\":75,\"dew_point\":15.02,\"uvi\":6.33,\"clouds\":90,\"visibility\":10000,\"wind_speed\":4.84,\"wind_deg\":90,\"wind_gust\":8.21,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.53},{\"dt\":1619809200,\"temp\":20.04,\"feels_like\":20.11,\"pressure\":1021,\"humidity\":77,\"dew_point\":15.89,\"uvi\":3.88,\"clouds\":95,\"visibility\":10000,\"wind_speed\":4.72,\"wind_deg\":100,\"wind_gust\":8.17,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.15},{\"dt\":1619812800,\"temp\":20.82,\"feels_like\":20.97,\"pressure\":1021,\"humidity\":77,\"dew_point\":16.78,\"uvi\":3.23,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.89,\"wind_deg\":105,\"wind_gust\":7.21,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.03},{\"dt\":1619816400,\"temp\":21.23,\"feels_like\":21.34,\"pressure\":1021,\"humidity\":74,\"dew_point\":16.57,\"uvi\":2.26,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.51,\"wind_deg\":120,\"wind_gust\":6.3,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.03},{\"dt\":1619820000,\"temp\":20.67,\"feels_like\":20.83,\"pressure\":1020,\"humidity\":78,\"dew_point\":16.85,\"uvi\":0.24,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.59,\"wind_deg\":125,\"wind_gust\":5.87,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.02},{\"dt\":1619823600,\"temp\":19.51,\"feels_like\":19.68,\"pressure\":1020,\"humidity\":83,\"dew_point\":16.81,\"uvi\":0.1,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.64,\"wind_deg\":131,\"wind_gust\":6.56,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.02},{\"dt\":1619827200,\"temp\":18.81,\"feels_like\":18.94,\"pressure\":1020,\"humidity\":84,\"dew_point\":16.25,\"uvi\":0.02,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.82,\"wind_deg\":124,\"wind_gust\":7.22,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.02},{\"dt\":1619830800,\"temp\":18.22,\"feels_like\":18.24,\"pressure\":1020,\"humidity\":82,\"dew_point\":15.29,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.37,\"wind_deg\":127,\"wind_gust\":6.34,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0},{\"dt\":1619834400,\"temp\":18.16,\"feels_like\":18.12,\"pressure\":1021,\"humidity\":80,\"dew_point\":14.88,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.02,\"wind_deg\":121,\"wind_gust\":5.72,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0},{\"dt\":1619838000,\"temp\":18.13,\"feels_like\":18.04,\"pressure\":1021,\"humidity\":78,\"dew_point\":14.47,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.25,\"wind_deg\":107,\"wind_gust\":5.84,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.05},{\"dt\":1619841600,\"temp\":18.05,\"feels_like\":17.92,\"pressure\":1021,\"humidity\":77,\"dew_point\":14.16,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.14,\"wind_deg\":98,\"wind_gust\":5.73,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.05},{\"dt\":1619845200,\"temp\":17.93,\"feels_like\":17.79,\"pressure\":1021,\"humidity\":77,\"dew_point\":14.06,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.41,\"wind_deg\":104,\"wind_gust\":6.06,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.05},{\"dt\":1619848800,\"temp\":17.77,\"feels_like\":17.61,\"pressure\":1021,\"humidity\":77,\"dew_point\":13.81,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.21,\"wind_deg\":107,\"wind_gust\":5.64,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.09},{\"dt\":1619852400,\"temp\":17.53,\"feels_like\":17.35,\"pressure\":1020,\"humidity\":77,\"dew_point\":13.61,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.3,\"wind_deg\":97,\"wind_gust\":5.68,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0},{\"dt\":1619856000,\"temp\":17.29,\"feels_like\":17.09,\"pressure\":1019,\"humidity\":77,\"dew_point\":13.27,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":1.87,\"wind_deg\":108,\"wind_gust\":4.34,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.01},{\"dt\":1619859600,\"temp\":16.93,\"feels_like\":16.69,\"pressure\":1019,\"humidity\":77,\"dew_point\":13.03,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":1.89,\"wind_deg\":126,\"wind_gust\":4.13,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.01},{\"dt\":1619863200,\"temp\":16.84,\"feels_like\":16.59,\"pressure\":1019,\"humidity\":77,\"dew_point\":13.03,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":1.96,\"wind_deg\":108,\"wind_gust\":4.07,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.01},{\"dt\":1619866800,\"temp\":16.56,\"feels_like\":16.31,\"pressure\":1019,\"humidity\":78,\"dew_point\":12.93,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.25,\"wind_deg\":105,\"wind_gust\":4.89,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0},{\"dt\":1619870400,\"temp\":16.07,\"feels_like\":15.87,\"pressure\":1020,\"humidity\":82,\"dew_point\":13.12,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.1,\"wind_deg\":143,\"wind_gust\":4.32,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619874000,\"temp\":16.56,\"feels_like\":16.46,\"pressure\":1020,\"humidity\":84,\"dew_point\":13.89,\"uvi\":0.39,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2,\"wind_deg\":132,\"wind_gust\":5.67,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619877600,\"temp\":17.34,\"feels_like\":17.24,\"pressure\":1020,\"humidity\":81,\"dew_point\":14.17,\"uvi\":1.19,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.11,\"wind_deg\":140,\"wind_gust\":5.02,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619881200,\"temp\":17.81,\"feels_like\":17.71,\"pressure\":1019,\"humidity\":79,\"dew_point\":14.28,\"uvi\":2.5,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.75,\"wind_deg\":129,\"wind_gust\":5.3,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619884800,\"temp\":19.08,\"feels_like\":18.98,\"pressure\":1019,\"humidity\":74,\"dew_point\":14.36,\"uvi\":5.01,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.05,\"wind_deg\":133,\"wind_gust\":5.41,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619888400,\"temp\":20.52,\"feels_like\":20.38,\"pressure\":1018,\"humidity\":67,\"dew_point\":14.38,\"uvi\":6.66,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.45,\"wind_deg\":134,\"wind_gust\":5.11,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619892000,\"temp\":20.73,\"feels_like\":20.58,\"pressure\":1018,\"humidity\":66,\"dew_point\":14.29,\"uvi\":7.51,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.84,\"wind_deg\":135,\"wind_gust\":5.46,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619895600,\"temp\":20.14,\"feels_like\":20.06,\"pressure\":1016,\"humidity\":71,\"dew_point\":14.86,\"uvi\":6.22,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.33,\"wind_deg\":126,\"wind_gust\":5.51,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619899200,\"temp\":20.61,\"feels_like\":20.55,\"pressure\":1016,\"humidity\":70,\"dew_point\":15.19,\"uvi\":5.18,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.21,\"wind_deg\":133,\"wind_gust\":4.34,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619902800,\"temp\":21.51,\"feels_like\":21.54,\"pressure\":1015,\"humidity\":70,\"dew_point\":15.81,\"uvi\":3.62,\"clouds\":100,\"visibility\":10000,\"wind_speed\":1.99,\"wind_deg\":133,\"wind_gust\":4.11,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619906400,\"temp\":21.91,\"feels_like\":22.01,\"pressure\":1014,\"humidity\":71,\"dew_point\":16.7,\"uvi\":1.38,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.07,\"wind_deg\":148,\"wind_gust\":4.09,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619910000,\"temp\":20.68,\"feels_like\":20.89,\"pressure\":1014,\"humidity\":80,\"dew_point\":17.18,\"uvi\":0.57,\"clouds\":100,\"visibility\":10000,\"wind_speed\":1.83,\"wind_deg\":151,\"wind_gust\":3.98,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619913600,\"temp\":19.41,\"feels_like\":19.57,\"pressure\":1013,\"humidity\":83,\"dew_point\":16.6,\"uvi\":0.15,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.29,\"wind_deg\":155,\"wind_gust\":3.77,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619917200,\"temp\":19,\"feels_like\":19.2,\"pressure\":1013,\"humidity\":86,\"dew_point\":16.67,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.07,\"wind_deg\":142,\"wind_gust\":3.46,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0},{\"dt\":1619920800,\"temp\":18.83,\"feels_like\":19.01,\"pressure\":1013,\"humidity\":86,\"dew_point\":16.64,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.54,\"wind_deg\":145,\"wind_gust\":5.18,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0},{\"dt\":1619924400,\"temp\":18.15,\"feels_like\":18.32,\"pressure\":1013,\"humidity\":88,\"dew_point\":16.33,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.54,\"wind_deg\":139,\"wind_gust\":6.41,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.01},{\"dt\":1619928000,\"temp\":17.67,\"feels_like\":17.84,\"pressure\":1013,\"humidity\":90,\"dew_point\":16.09,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.05,\"wind_deg\":145,\"wind_gust\":4.99,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.15},{\"dt\":1619931600,\"temp\":17.47,\"feels_like\":17.65,\"pressure\":1012,\"humidity\":91,\"dew_point\":16.14,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.07,\"wind_deg\":133,\"wind_gust\":4.94,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.32},{\"dt\":1619935200,\"temp\":17.53,\"feels_like\":17.74,\"pressure\":1012,\"humidity\":92,\"dew_point\":16.39,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.27,\"wind_deg\":141,\"wind_gust\":6.25,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.32},{\"dt\":1619938800,\"temp\":17.54,\"feels_like\":17.83,\"pressure\":1011,\"humidity\":95,\"dew_point\":16.9,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.31,\"wind_deg\":140,\"wind_gust\":7.04,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"pop\":0.45,\"rain\":{\"1h\":0.24}},{\"dt\":1619942400,\"temp\":17.6,\"feels_like\":17.95,\"pressure\":1010,\"humidity\":97,\"dew_point\":17.2,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.26,\"wind_deg\":139,\"wind_gust\":7.28,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"pop\":0.53,\"rain\":{\"1h\":0.11}},{\"dt\":1619946000,\"temp\":17.62,\"feels_like\":17.97,\"pressure\":1009,\"humidity\":97,\"dew_point\":17.27,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":1.95,\"wind_deg\":164,\"wind_gust\":6.43,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"pop\":0.64,\"rain\":{\"1h\":0.14}},{\"dt\":1619949600,\"temp\":17.4,\"feels_like\":17.73,\"pressure\":1008,\"humidity\":97,\"dew_point\":17.12,\"uvi\":0,\"clouds\":98,\"visibility\":10000,\"wind_speed\":1.92,\"wind_deg\":143,\"wind_gust\":4.19,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"pop\":0.75,\"rain\":{\"1h\":0.3}},{\"dt\":1619953200,\"temp\":17.37,\"feels_like\":17.72,\"pressure\":1008,\"humidity\":98,\"dew_point\":17.21,\"uvi\":0,\"clouds\":99,\"visibility\":10000,\"wind_speed\":2.41,\"wind_deg\":127,\"wind_gust\":6.12,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"pop\":0.86,\"rain\":{\"1h\":0.65}},{\"dt\":1619956800,\"temp\":17.44,\"feels_like\":17.8,\"pressure\":1007,\"humidity\":98,\"dew_point\":17.31,\"uvi\":0,\"clouds\":99,\"visibility\":10000,\"wind_speed\":1.85,\"wind_deg\":109,\"wind_gust\":4.5,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"pop\":1,\"rain\":{\"1h\":0.25}},{\"dt\":1619960400,\"temp\":17.65,\"feels_like\":18.03,\"pressure\":1008,\"humidity\":98,\"dew_point\":17.49,\"uvi\":0.41,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.17,\"wind_deg\":131,\"wind_gust\":8.9,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"pop\":0.76,\"rain\":{\"1h\":1.34}}],\"daily\":[{\"dt\":1619805600,\"sunrise\":1619782111,\"sunset\":1619830677,\"moonrise\":0,\"moonset\":1619792640,\"moon_phase\":0.64,\"temp\":{\"day\":19.57,\"min\":17.25,\"max\":21.23,\"night\":18.05,\"eve\":18.81,\"morn\":17.25},\"feels_like\":{\"day\":19.54,\"night\":16.96,\"eve\":18.94,\"morn\":16.96},\"pressure\":1022,\"humidity\":75,\"dew_point\":15.02,\"wind_speed\":5.27,\"wind_deg\":49,\"wind_gust\":13.42,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":90,\"pop\":0.61,\"rain\":1.17,\"uvi\":6.33},{\"dt\":1619892000,\"sunrise\":1619868452,\"sunset\":1619917123,\"moonrise\":1619846880,\"moonset\":1619882640,\"moon_phase\":0.68,\"temp\":{\"day\":20.73,\"min\":16.07,\"max\":21.91,\"night\":17.67,\"eve\":19.41,\"morn\":16.07},\"feels_like\":{\"day\":20.58,\"night\":15.87,\"eve\":19.57,\"morn\":15.87},\"pressure\":1018,\"humidity\":66,\"dew_point\":14.29,\"wind_speed\":3.84,\"wind_deg\":135,\"wind_gust\":6.41,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":100,\"pop\":0.15,\"uvi\":7.51},{\"dt\":1619978400,\"sunrise\":1619954793,\"sunset\":1620003570,\"moonrise\":1619936820,\"moonset\":1619972880,\"moon_phase\":0.71,\"temp\":{\"day\":23.55,\"min\":17.37,\"max\":24.18,\"night\":18.5,\"eve\":22.62,\"morn\":17.44},\"feels_like\":{\"day\":23.89,\"night\":17.8,\"eve\":23.08,\"morn\":17.8},\"pressure\":1004,\"humidity\":74,\"dew_point\":18.8,\"wind_speed\":4.9,\"wind_deg\":202,\"wind_gust\":11.33,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"clouds\":92,\"pop\":1,\"rain\":10.13,\"uvi\":6.8},{\"dt\":1620064800,\"sunrise\":1620041136,\"sunset\":1620090016,\"moonrise\":1620026160,\"moonset\":1620063120,\"moon_phase\":0.75,\"temp\":{\"day\":30.04,\"min\":18.05,\"max\":31.29,\"night\":23.34,\"eve\":27.66,\"morn\":20.11},\"feels_like\":{\"day\":32.91,\"night\":20.68,\"eve\":30.26,\"morn\":20.68},\"pressure\":1002,\"humidity\":60,\"dew_point\":21.67,\"wind_speed\":6.81,\"wind_deg\":192,\"wind_gust\":14.01,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":55,\"pop\":0.39,\"rain\":0.18,\"uvi\":9.86},{\"dt\":1620151200,\"sunrise\":1620127480,\"sunset\":1620176463,\"moonrise\":1620115080,\"moonset\":1620153360,\"moon_phase\":0.78,\"temp\":{\"day\":21.51,\"min\":19.19,\"max\":22.74,\"night\":19.19,\"eve\":21.48,\"morn\":20.5},\"feels_like\":{\"day\":21.99,\"night\":21.16,\"eve\":21.96,\"morn\":21.16},\"pressure\":1011,\"humidity\":87,\"dew_point\":19.35,\"wind_speed\":5.03,\"wind_deg\":211,\"wind_gust\":10.39,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"clouds\":100,\"pop\":0.99,\"rain\":5.12,\"uvi\":0.1},{\"dt\":1620237600,\"sunrise\":1620213826,\"sunset\":1620262909,\"moonrise\":1620203580,\"moonset\":1620243360,\"moon_phase\":0.81,\"temp\":{\"day\":19.4,\"min\":15.22,\"max\":21.46,\"night\":17.93,\"eve\":19.75,\"morn\":15.22},\"feels_like\":{\"day\":19.3,\"night\":15.25,\"eve\":19.82,\"morn\":15.25},\"pressure\":1018,\"humidity\":73,\"dew_point\":14.69,\"wind_speed\":4.25,\"wind_deg\":14,\"wind_gust\":8.95,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":100,\"pop\":0.35,\"rain\":0.85,\"uvi\":1},{\"dt\":1620324000,\"sunrise\":1620300172,\"sunset\":1620349355,\"moonrise\":1620291840,\"moonset\":1620333300,\"moon_phase\":0.84,\"temp\":{\"day\":20.97,\"min\":12.28,\"max\":20.97,\"night\":12.28,\"eve\":17.57,\"morn\":13.85},\"feels_like\":{\"day\":20.87,\"night\":13.56,\"eve\":17.37,\"morn\":13.56},\"pressure\":1021,\"humidity\":67,\"dew_point\":14.8,\"wind_speed\":4.89,\"wind_deg\":14,\"wind_gust\":7.46,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":70,\"pop\":0.41,\"rain\":1.32,\"uvi\":1},{\"dt\":1620410400,\"sunrise\":1620386520,\"sunset\":1620435802,\"moonrise\":1620379920,\"moonset\":1620423060,\"moon_phase\":0.88,\"temp\":{\"day\":22.13,\"min\":9.37,\"max\":23.83,\"night\":15.74,\"eve\":20.77,\"morn\":9.87},\"feels_like\":{\"day\":21.76,\"night\":9.13,\"eve\":20.78,\"morn\":9.13},\"pressure\":1021,\"humidity\":52,\"dew_point\":11.9,\"wind_speed\":2.9,\"wind_deg\":178,\"wind_gust\":5.16,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":0,\"pop\":0,\"uvi\":1}]}";
        parseWeatherJson(weatherJson, weatherData1);
        System.out.println(weatherData1.toString());
        drawWeather(weatherData1);*/
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

    public void loadDataToWeatherData(WeatherData weatherData, String city) {
        city = city.replaceAll(" ", "%20");
        String latLongJson = getUrlContentLatLng("https://maps.googleapis.com/maps/api/geocode/json?address=" + city + "&language=ru&key=AIzaSyB2s7qxSAbtcJYrP7anzjrT9SjODKNMBWQ");
        parseLatLongJson(latLongJson, weatherData);

        //String weatherJson = "{\"lat\":33.44,\"lon\":-94.04,\"timezone\":\"America/Chicago\",\"timezone_offset\":-18000,\"current\":{\"dt\":1619794365,\"sunrise\":1619782111,\"sunset\":1619830677,\"temp\":18.11,\"feels_like\":17.75,\"pressure\":1022,\"humidity\":68,\"dew_point\":12.12,\"uvi\":1.49,\"clouds\":75,\"visibility\":10000,\"wind_speed\":3.09,\"wind_deg\":70,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}]},\"hourly\":[{\"dt\":1619791200,\"temp\":17.77,\"feels_like\":17.48,\"pressure\":1022,\"humidity\":72,\"dew_point\":12.66,\"uvi\":0.7,\"clouds\":80,\"visibility\":10000,\"wind_speed\":3.1,\"wind_deg\":67,\"wind_gust\":10.83,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"pop\":0.57,\"rain\":{\"1h\":0.6}},{\"dt\":1619794800,\"temp\":18.11,\"feels_like\":17.75,\"pressure\":1022,\"humidity\":68,\"dew_point\":12.12,\"uvi\":1.49,\"clouds\":75,\"visibility\":10000,\"wind_speed\":3.41,\"wind_deg\":72,\"wind_gust\":11.38,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"pop\":0.61},{\"dt\":1619798400,\"temp\":18.24,\"feels_like\":18,\"pressure\":1022,\"humidity\":72,\"dew_point\":13.11,\"uvi\":4.22,\"clouds\":80,\"visibility\":10000,\"wind_speed\":4.96,\"wind_deg\":92,\"wind_gust\":11.12,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"pop\":0.57},{\"dt\":1619802000,\"temp\":18.72,\"feels_like\":18.58,\"pressure\":1022,\"humidity\":74,\"dew_point\":14,\"uvi\":5.62,\"clouds\":85,\"visibility\":10000,\"wind_speed\":5.15,\"wind_deg\":92,\"wind_gust\":10.16,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.57},{\"dt\":1619805600,\"temp\":19.57,\"feels_like\":19.54,\"pressure\":1022,\"humidity\":75,\"dew_point\":15.02,\"uvi\":6.33,\"clouds\":90,\"visibility\":10000,\"wind_speed\":4.84,\"wind_deg\":90,\"wind_gust\":8.21,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.53},{\"dt\":1619809200,\"temp\":20.04,\"feels_like\":20.11,\"pressure\":1021,\"humidity\":77,\"dew_point\":15.89,\"uvi\":3.88,\"clouds\":95,\"visibility\":10000,\"wind_speed\":4.72,\"wind_deg\":100,\"wind_gust\":8.17,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.15},{\"dt\":1619812800,\"temp\":20.82,\"feels_like\":20.97,\"pressure\":1021,\"humidity\":77,\"dew_point\":16.78,\"uvi\":3.23,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.89,\"wind_deg\":105,\"wind_gust\":7.21,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.03},{\"dt\":1619816400,\"temp\":21.23,\"feels_like\":21.34,\"pressure\":1021,\"humidity\":74,\"dew_point\":16.57,\"uvi\":2.26,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.51,\"wind_deg\":120,\"wind_gust\":6.3,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.03},{\"dt\":1619820000,\"temp\":20.67,\"feels_like\":20.83,\"pressure\":1020,\"humidity\":78,\"dew_point\":16.85,\"uvi\":0.24,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.59,\"wind_deg\":125,\"wind_gust\":5.87,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.02},{\"dt\":1619823600,\"temp\":19.51,\"feels_like\":19.68,\"pressure\":1020,\"humidity\":83,\"dew_point\":16.81,\"uvi\":0.1,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.64,\"wind_deg\":131,\"wind_gust\":6.56,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.02},{\"dt\":1619827200,\"temp\":18.81,\"feels_like\":18.94,\"pressure\":1020,\"humidity\":84,\"dew_point\":16.25,\"uvi\":0.02,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.82,\"wind_deg\":124,\"wind_gust\":7.22,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0.02},{\"dt\":1619830800,\"temp\":18.22,\"feels_like\":18.24,\"pressure\":1020,\"humidity\":82,\"dew_point\":15.29,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.37,\"wind_deg\":127,\"wind_gust\":6.34,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0},{\"dt\":1619834400,\"temp\":18.16,\"feels_like\":18.12,\"pressure\":1021,\"humidity\":80,\"dew_point\":14.88,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.02,\"wind_deg\":121,\"wind_gust\":5.72,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0},{\"dt\":1619838000,\"temp\":18.13,\"feels_like\":18.04,\"pressure\":1021,\"humidity\":78,\"dew_point\":14.47,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.25,\"wind_deg\":107,\"wind_gust\":5.84,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.05},{\"dt\":1619841600,\"temp\":18.05,\"feels_like\":17.92,\"pressure\":1021,\"humidity\":77,\"dew_point\":14.16,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.14,\"wind_deg\":98,\"wind_gust\":5.73,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.05},{\"dt\":1619845200,\"temp\":17.93,\"feels_like\":17.79,\"pressure\":1021,\"humidity\":77,\"dew_point\":14.06,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.41,\"wind_deg\":104,\"wind_gust\":6.06,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.05},{\"dt\":1619848800,\"temp\":17.77,\"feels_like\":17.61,\"pressure\":1021,\"humidity\":77,\"dew_point\":13.81,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.21,\"wind_deg\":107,\"wind_gust\":5.64,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.09},{\"dt\":1619852400,\"temp\":17.53,\"feels_like\":17.35,\"pressure\":1020,\"humidity\":77,\"dew_point\":13.61,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.3,\"wind_deg\":97,\"wind_gust\":5.68,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0},{\"dt\":1619856000,\"temp\":17.29,\"feels_like\":17.09,\"pressure\":1019,\"humidity\":77,\"dew_point\":13.27,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":1.87,\"wind_deg\":108,\"wind_gust\":4.34,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.01},{\"dt\":1619859600,\"temp\":16.93,\"feels_like\":16.69,\"pressure\":1019,\"humidity\":77,\"dew_point\":13.03,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":1.89,\"wind_deg\":126,\"wind_gust\":4.13,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.01},{\"dt\":1619863200,\"temp\":16.84,\"feels_like\":16.59,\"pressure\":1019,\"humidity\":77,\"dew_point\":13.03,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":1.96,\"wind_deg\":108,\"wind_gust\":4.07,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.01},{\"dt\":1619866800,\"temp\":16.56,\"feels_like\":16.31,\"pressure\":1019,\"humidity\":78,\"dew_point\":12.93,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.25,\"wind_deg\":105,\"wind_gust\":4.89,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0},{\"dt\":1619870400,\"temp\":16.07,\"feels_like\":15.87,\"pressure\":1020,\"humidity\":82,\"dew_point\":13.12,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.1,\"wind_deg\":143,\"wind_gust\":4.32,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619874000,\"temp\":16.56,\"feels_like\":16.46,\"pressure\":1020,\"humidity\":84,\"dew_point\":13.89,\"uvi\":0.39,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2,\"wind_deg\":132,\"wind_gust\":5.67,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619877600,\"temp\":17.34,\"feels_like\":17.24,\"pressure\":1020,\"humidity\":81,\"dew_point\":14.17,\"uvi\":1.19,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.11,\"wind_deg\":140,\"wind_gust\":5.02,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619881200,\"temp\":17.81,\"feels_like\":17.71,\"pressure\":1019,\"humidity\":79,\"dew_point\":14.28,\"uvi\":2.5,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.75,\"wind_deg\":129,\"wind_gust\":5.3,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619884800,\"temp\":19.08,\"feels_like\":18.98,\"pressure\":1019,\"humidity\":74,\"dew_point\":14.36,\"uvi\":5.01,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.05,\"wind_deg\":133,\"wind_gust\":5.41,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619888400,\"temp\":20.52,\"feels_like\":20.38,\"pressure\":1018,\"humidity\":67,\"dew_point\":14.38,\"uvi\":6.66,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.45,\"wind_deg\":134,\"wind_gust\":5.11,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619892000,\"temp\":20.73,\"feels_like\":20.58,\"pressure\":1018,\"humidity\":66,\"dew_point\":14.29,\"uvi\":7.51,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.84,\"wind_deg\":135,\"wind_gust\":5.46,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619895600,\"temp\":20.14,\"feels_like\":20.06,\"pressure\":1016,\"humidity\":71,\"dew_point\":14.86,\"uvi\":6.22,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.33,\"wind_deg\":126,\"wind_gust\":5.51,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619899200,\"temp\":20.61,\"feels_like\":20.55,\"pressure\":1016,\"humidity\":70,\"dew_point\":15.19,\"uvi\":5.18,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.21,\"wind_deg\":133,\"wind_gust\":4.34,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619902800,\"temp\":21.51,\"feels_like\":21.54,\"pressure\":1015,\"humidity\":70,\"dew_point\":15.81,\"uvi\":3.62,\"clouds\":100,\"visibility\":10000,\"wind_speed\":1.99,\"wind_deg\":133,\"wind_gust\":4.11,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619906400,\"temp\":21.91,\"feels_like\":22.01,\"pressure\":1014,\"humidity\":71,\"dew_point\":16.7,\"uvi\":1.38,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.07,\"wind_deg\":148,\"wind_gust\":4.09,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619910000,\"temp\":20.68,\"feels_like\":20.89,\"pressure\":1014,\"humidity\":80,\"dew_point\":17.18,\"uvi\":0.57,\"clouds\":100,\"visibility\":10000,\"wind_speed\":1.83,\"wind_deg\":151,\"wind_gust\":3.98,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619913600,\"temp\":19.41,\"feels_like\":19.57,\"pressure\":1013,\"humidity\":83,\"dew_point\":16.6,\"uvi\":0.15,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.29,\"wind_deg\":155,\"wind_gust\":3.77,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"pop\":0},{\"dt\":1619917200,\"temp\":19,\"feels_like\":19.2,\"pressure\":1013,\"humidity\":86,\"dew_point\":16.67,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.07,\"wind_deg\":142,\"wind_gust\":3.46,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0},{\"dt\":1619920800,\"temp\":18.83,\"feels_like\":19.01,\"pressure\":1013,\"humidity\":86,\"dew_point\":16.64,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.54,\"wind_deg\":145,\"wind_gust\":5.18,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0},{\"dt\":1619924400,\"temp\":18.15,\"feels_like\":18.32,\"pressure\":1013,\"humidity\":88,\"dew_point\":16.33,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.54,\"wind_deg\":139,\"wind_gust\":6.41,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.01},{\"dt\":1619928000,\"temp\":17.67,\"feels_like\":17.84,\"pressure\":1013,\"humidity\":90,\"dew_point\":16.09,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.05,\"wind_deg\":145,\"wind_gust\":4.99,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.15},{\"dt\":1619931600,\"temp\":17.47,\"feels_like\":17.65,\"pressure\":1012,\"humidity\":91,\"dew_point\":16.14,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.07,\"wind_deg\":133,\"wind_gust\":4.94,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.32},{\"dt\":1619935200,\"temp\":17.53,\"feels_like\":17.74,\"pressure\":1012,\"humidity\":92,\"dew_point\":16.39,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.27,\"wind_deg\":141,\"wind_gust\":6.25,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"pop\":0.32},{\"dt\":1619938800,\"temp\":17.54,\"feels_like\":17.83,\"pressure\":1011,\"humidity\":95,\"dew_point\":16.9,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.31,\"wind_deg\":140,\"wind_gust\":7.04,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"pop\":0.45,\"rain\":{\"1h\":0.24}},{\"dt\":1619942400,\"temp\":17.6,\"feels_like\":17.95,\"pressure\":1010,\"humidity\":97,\"dew_point\":17.2,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":2.26,\"wind_deg\":139,\"wind_gust\":7.28,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"pop\":0.53,\"rain\":{\"1h\":0.11}},{\"dt\":1619946000,\"temp\":17.62,\"feels_like\":17.97,\"pressure\":1009,\"humidity\":97,\"dew_point\":17.27,\"uvi\":0,\"clouds\":100,\"visibility\":10000,\"wind_speed\":1.95,\"wind_deg\":164,\"wind_gust\":6.43,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"pop\":0.64,\"rain\":{\"1h\":0.14}},{\"dt\":1619949600,\"temp\":17.4,\"feels_like\":17.73,\"pressure\":1008,\"humidity\":97,\"dew_point\":17.12,\"uvi\":0,\"clouds\":98,\"visibility\":10000,\"wind_speed\":1.92,\"wind_deg\":143,\"wind_gust\":4.19,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"pop\":0.75,\"rain\":{\"1h\":0.3}},{\"dt\":1619953200,\"temp\":17.37,\"feels_like\":17.72,\"pressure\":1008,\"humidity\":98,\"dew_point\":17.21,\"uvi\":0,\"clouds\":99,\"visibility\":10000,\"wind_speed\":2.41,\"wind_deg\":127,\"wind_gust\":6.12,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"pop\":0.86,\"rain\":{\"1h\":0.65}},{\"dt\":1619956800,\"temp\":17.44,\"feels_like\":17.8,\"pressure\":1007,\"humidity\":98,\"dew_point\":17.31,\"uvi\":0,\"clouds\":99,\"visibility\":10000,\"wind_speed\":1.85,\"wind_deg\":109,\"wind_gust\":4.5,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"pop\":1,\"rain\":{\"1h\":0.25}},{\"dt\":1619960400,\"temp\":17.65,\"feels_like\":18.03,\"pressure\":1008,\"humidity\":98,\"dew_point\":17.49,\"uvi\":0.41,\"clouds\":100,\"visibility\":10000,\"wind_speed\":3.17,\"wind_deg\":131,\"wind_gust\":8.9,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"pop\":0.76,\"rain\":{\"1h\":1.34}}],\"daily\":[{\"dt\":1619805600,\"sunrise\":1619782111,\"sunset\":1619830677,\"moonrise\":0,\"moonset\":1619792640,\"moon_phase\":0.64,\"temp\":{\"day\":19.57,\"min\":17.25,\"max\":21.23,\"night\":18.05,\"eve\":18.81,\"morn\":17.25},\"feels_like\":{\"day\":19.54,\"night\":16.96,\"eve\":18.94,\"morn\":16.96},\"pressure\":1022,\"humidity\":75,\"dew_point\":15.02,\"wind_speed\":5.27,\"wind_deg\":49,\"wind_gust\":13.42,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":90,\"pop\":0.61,\"rain\":1.17,\"uvi\":6.33},{\"dt\":1619892000,\"sunrise\":1619868452,\"sunset\":1619917123,\"moonrise\":1619846880,\"moonset\":1619882640,\"moon_phase\":0.68,\"temp\":{\"day\":20.73,\"min\":16.07,\"max\":21.91,\"night\":17.67,\"eve\":19.41,\"morn\":16.07},\"feels_like\":{\"day\":20.58,\"night\":15.87,\"eve\":19.57,\"morn\":15.87},\"pressure\":1018,\"humidity\":66,\"dew_point\":14.29,\"wind_speed\":3.84,\"wind_deg\":135,\"wind_gust\":6.41,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":100,\"pop\":0.15,\"uvi\":7.51},{\"dt\":1619978400,\"sunrise\":1619954793,\"sunset\":1620003570,\"moonrise\":1619936820,\"moonset\":1619972880,\"moon_phase\":0.71,\"temp\":{\"day\":23.55,\"min\":17.37,\"max\":24.18,\"night\":18.5,\"eve\":22.62,\"morn\":17.44},\"feels_like\":{\"day\":23.89,\"night\":17.8,\"eve\":23.08,\"morn\":17.8},\"pressure\":1004,\"humidity\":74,\"dew_point\":18.8,\"wind_speed\":4.9,\"wind_deg\":202,\"wind_gust\":11.33,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"clouds\":92,\"pop\":1,\"rain\":10.13,\"uvi\":6.8},{\"dt\":1620064800,\"sunrise\":1620041136,\"sunset\":1620090016,\"moonrise\":1620026160,\"moonset\":1620063120,\"moon_phase\":0.75,\"temp\":{\"day\":30.04,\"min\":18.05,\"max\":31.29,\"night\":23.34,\"eve\":27.66,\"morn\":20.11},\"feels_like\":{\"day\":32.91,\"night\":20.68,\"eve\":30.26,\"morn\":20.68},\"pressure\":1002,\"humidity\":60,\"dew_point\":21.67,\"wind_speed\":6.81,\"wind_deg\":192,\"wind_gust\":14.01,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":55,\"pop\":0.39,\"rain\":0.18,\"uvi\":9.86},{\"dt\":1620151200,\"sunrise\":1620127480,\"sunset\":1620176463,\"moonrise\":1620115080,\"moonset\":1620153360,\"moon_phase\":0.78,\"temp\":{\"day\":21.51,\"min\":19.19,\"max\":22.74,\"night\":19.19,\"eve\":21.48,\"morn\":20.5},\"feels_like\":{\"day\":21.99,\"night\":21.16,\"eve\":21.96,\"morn\":21.16},\"pressure\":1011,\"humidity\":87,\"dew_point\":19.35,\"wind_speed\":5.03,\"wind_deg\":211,\"wind_gust\":10.39,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"clouds\":100,\"pop\":0.99,\"rain\":5.12,\"uvi\":0.1},{\"dt\":1620237600,\"sunrise\":1620213826,\"sunset\":1620262909,\"moonrise\":1620203580,\"moonset\":1620243360,\"moon_phase\":0.81,\"temp\":{\"day\":19.4,\"min\":15.22,\"max\":21.46,\"night\":17.93,\"eve\":19.75,\"morn\":15.22},\"feels_like\":{\"day\":19.3,\"night\":15.25,\"eve\":19.82,\"morn\":15.25},\"pressure\":1018,\"humidity\":73,\"dew_point\":14.69,\"wind_speed\":4.25,\"wind_deg\":14,\"wind_gust\":8.95,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":100,\"pop\":0.35,\"rain\":0.85,\"uvi\":1},{\"dt\":1620324000,\"sunrise\":1620300172,\"sunset\":1620349355,\"moonrise\":1620291840,\"moonset\":1620333300,\"moon_phase\":0.84,\"temp\":{\"day\":20.97,\"min\":12.28,\"max\":20.97,\"night\":12.28,\"eve\":17.57,\"morn\":13.85},\"feels_like\":{\"day\":20.87,\"night\":13.56,\"eve\":17.37,\"morn\":13.56},\"pressure\":1021,\"humidity\":67,\"dew_point\":14.8,\"wind_speed\":4.89,\"wind_deg\":14,\"wind_gust\":7.46,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":70,\"pop\":0.41,\"rain\":1.32,\"uvi\":1},{\"dt\":1620410400,\"sunrise\":1620386520,\"sunset\":1620435802,\"moonrise\":1620379920,\"moonset\":1620423060,\"moon_phase\":0.88,\"temp\":{\"day\":22.13,\"min\":9.37,\"max\":23.83,\"night\":15.74,\"eve\":20.77,\"morn\":9.87},\"feels_like\":{\"day\":21.76,\"night\":9.13,\"eve\":20.78,\"morn\":9.13},\"pressure\":1021,\"humidity\":52,\"dew_point\":11.9,\"wind_speed\":2.9,\"wind_deg\":178,\"wind_gust\":5.16,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":0,\"pop\":0,\"uvi\":1}]}";
        String weatherJson = getUrlContentWeather("https://api.openweathermap.org/data/2.5/onecall?lat=" + weatherData.latCord + "&lon=" + weatherData.longCord + "&exclude=minutely,alerts&units=metric&appid=65a905f558f9f4a582c496c9bd139cda");
        parseWeatherJson(weatherJson, weatherData);
    }

    public String getTimeFromUnits(int unixSeconds) {
        Date date = new Date(unixSeconds * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        return sdf.format(date);
    }

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
            //createErrorDialog("Ошибка при обращении к OpenWeather API");
        }
        return content.toString();
    }

    public String getUrlContentLatLng(String urlAddress) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urlAddress);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            /*HttpURLConnection httpConn = (HttpURLConnection)connection;
            InputStream is;
            if (httpConn.getResponseCode() >= 400) {
                is = httpConn.getErrorStream();
            } else {
                is = httpConn.getInputStream();
            }*/

            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(((HttpURLConnection) (new URL(urlAddress)).openConnection()).getInputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            creteExceptionDialog(e, "Ошибка при обращении к Geocoding API.");
            //createErrorDialog("Ошибка при обращении к Geocoding API.");
        }


        return content.toString();
    }

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

    public void drawWeather(WeatherData weatherDataForDrawing) {
        city.setText(weatherDataForDrawing.city);
        current_Temperature.setText(weatherDataForDrawing.temperature);
        current_Time.setText(weatherDataForDrawing.current_Time);
        current_Humidity.setText("Влажность: " + weatherDataForDrawing.humidity);
        current_Wind.setText("Ветер: " + weatherDataForDrawing.wind);
        current_Pressure.setText("Давление: " + weatherDataForDrawing.pressure);
        current_Feels_Like.setText("Ощущается как " + weatherDataForDrawing.feels_Like);
        current_Weather_Image.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.weather_Type_Image));


        hours0.setText(weatherDataForDrawing.hours[0]);
        hours_Image0.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.hours_weather_Type_Images[0]));
        hours_Temperature0.setText(weatherDataForDrawing.hours_Temperatures[0]);

        hours01.setText(weatherDataForDrawing.hours[1]);
        hours_Image01.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.hours_weather_Type_Images[1]));
        hours_Temperature01.setText(weatherDataForDrawing.hours_Temperatures[1]);

        hours011.setText(weatherDataForDrawing.hours[2]);
        hours_Image011.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.hours_weather_Type_Images[2]));
        hours_Temperature011.setText(weatherDataForDrawing.hours_Temperatures[2]);

        hours012.setText(weatherDataForDrawing.hours[3]);
        hours_Image012.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.hours_weather_Type_Images[3]));
        hours_Temperature012.setText(weatherDataForDrawing.hours_Temperatures[3]);

        hours013.setText(weatherDataForDrawing.hours[4]);
        hours_Image013.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.hours_weather_Type_Images[4]));
        hours_Temperature013.setText(weatherDataForDrawing.hours_Temperatures[4]);

        hours014.setText(weatherDataForDrawing.hours[5]);
        hours_Image014.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.hours_weather_Type_Images[5]));
        hours_Temperature014.setText(weatherDataForDrawing.hours_Temperatures[5]);

        hours015.setText(weatherDataForDrawing.hours[6]);
        hours_Image015.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.hours_weather_Type_Images[6]));
        hours_Temperature015.setText(weatherDataForDrawing.hours_Temperatures[6]);

        hours016.setText(weatherDataForDrawing.hours[7]);
        hours_Image016.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.hours_weather_Type_Images[7]));
        hours_Temperature016.setText(weatherDataForDrawing.hours_Temperatures[7]);


        dates_Day_of_Week0.setText(weatherDataForDrawing.dates_Day_of_Week[0]);
        dates0.setText(weatherDataForDrawing.dates[0]);
        dates_Image0.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.dates_weather_Type_Images[0]));
        dates_Temperatures_Day0.setText(weatherDataForDrawing.dates_Temperatures_Day[0]);
        dates_Temperatures_Night0.setText(weatherDataForDrawing.dates_Temperatures_Night[0]);

        dates_Day_of_Week01.setText(weatherDataForDrawing.dates_Day_of_Week[1]);
        dates01.setText(weatherDataForDrawing.dates[1]);
        dates_Image01.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.dates_weather_Type_Images[1]));
        dates_Temperatures_Day01.setText(weatherDataForDrawing.dates_Temperatures_Day[1]);
        dates_Temperatures_Night01.setText(weatherDataForDrawing.dates_Temperatures_Night[1]);

        dates_Day_of_Week011.setText(weatherDataForDrawing.dates_Day_of_Week[2]);
        dates011.setText(weatherDataForDrawing.dates[2]);
        dates_Image011.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.dates_weather_Type_Images[2]));
        dates_Temperatures_Day011.setText(weatherDataForDrawing.dates_Temperatures_Day[2]);
        dates_Temperatures_Night011.setText(weatherDataForDrawing.dates_Temperatures_Night[2]);

        dates_Day_of_Week012.setText(weatherDataForDrawing.dates_Day_of_Week[3]);
        dates012.setText(weatherDataForDrawing.dates[3]);
        dates_Image012.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.dates_weather_Type_Images[3]));
        dates_Temperatures_Day012.setText(weatherDataForDrawing.dates_Temperatures_Day[3]);
        dates_Temperatures_Night012.setText(weatherDataForDrawing.dates_Temperatures_Night[3]);

        dates_Day_of_Week013.setText(weatherDataForDrawing.dates_Day_of_Week[4]);
        dates013.setText(weatherDataForDrawing.dates[4]);
        dates_Image013.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.dates_weather_Type_Images[4]));
        dates_Temperatures_Day013.setText(weatherDataForDrawing.dates_Temperatures_Day[4]);
        dates_Temperatures_Night013.setText(weatherDataForDrawing.dates_Temperatures_Night[4]);

        dates_Day_of_Week014.setText(weatherDataForDrawing.dates_Day_of_Week[5]);
        dates014.setText(weatherDataForDrawing.dates[5]);
        dates_Image014.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.dates_weather_Type_Images[5]));
        dates_Temperatures_Day014.setText(weatherDataForDrawing.dates_Temperatures_Day[5]);
        dates_Temperatures_Night014.setText(weatherDataForDrawing.dates_Temperatures_Night[5]);

        dates_Day_of_Week015.setText(weatherDataForDrawing.dates_Day_of_Week[6]);
        dates015.setText(weatherDataForDrawing.dates[6]);
        dates_Image015.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.dates_weather_Type_Images[6]));
        dates_Temperatures_Day015.setText(weatherDataForDrawing.dates_Temperatures_Day[6]);
        dates_Temperatures_Night015.setText(weatherDataForDrawing.dates_Temperatures_Night[6]);

        dates_Day_of_Week016.setText(weatherDataForDrawing.dates_Day_of_Week[7]);
        dates016.setText(weatherDataForDrawing.dates[7]);
        dates_Image016.setImage(new javafx.scene.image.Image("sample/resources/" + weatherDataForDrawing.dates_weather_Type_Images[7]));
        dates_Temperatures_Day016.setText(weatherDataForDrawing.dates_Temperatures_Day[7]);
        dates_Temperatures_Night016.setText(weatherDataForDrawing.dates_Temperatures_Night[7]);
    }
}
