package org.example.watch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        // Создаем метку для отображения времени
        Label timeLabel = new Label();
        timeLabel.setStyle("-fx-font-size: 48;"); // Устанавливаем размер шрифта

        // Создаем таймлайн для обновления времени каждую секунду
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String formattedTime = sdf.format(new Date());
                    timeLabel.setText(formattedTime);
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE); // Устанавливаем бесконечное выполнение

        // Начинаем таймлайн
        timeline.play();

        // Создаем корневой макет BorderPane
        BorderPane root = new BorderPane();

        // Устанавливаем синий фон
        BackgroundFill backgroundFill = new BackgroundFill(Color.BLUE, null, null);
        Background background = new Background(backgroundFill);
        root.setBackground(background);

        // Размещаем метку с временем в центре экрана
        root.setCenter(timeLabel);

        // Создаем сцену и добавляем на нее корневой макет
        Scene scene = new Scene(root, 400, 200, Color.BLUE);

        // Устанавливаем заголовок окна приложения
        stage.setTitle("Clock Application");

        // Устанавливаем сцену на Stage (окно приложения)
        stage.setScene(scene);

        // Показываем окно приложения
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}