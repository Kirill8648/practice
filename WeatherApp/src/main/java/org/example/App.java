package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Класс приложения
 *
 * @author Кирилл Аксенов и Владимир Майоров
 * @version 1.0
 */

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Процедура старта окна программы
     *
     * @param primaryStage - состояние окна программы
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/sample.fxml")));
        primaryStage.setTitle("WeatherApp");
        primaryStage.setScene(new Scene(root, 800, 506));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
