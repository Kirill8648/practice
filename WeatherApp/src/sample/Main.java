package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Класс запуска окна
 *
 * @author Кирилл Аксенов и Владимир Майоров
 * @version 1.0
 */

public class Main extends Application {

    /**
     * Процедура старта окна программы
     *
     * @param primaryStage - состояние окна программы
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        primaryStage.setTitle("WeatherApp");
        primaryStage.setScene(new Scene(root, 800, 506));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
