package com.example.lab_practice;

import com.example.lab_practice.MainScreen.MainScreenScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static final double WINDOW_WIDTH = 1440;
    private static final double WINDOW_HEIGHT = 810;

    @Override
    public void start(Stage primaryStage) {
        MainScreenScene mainScreenScene = new MainScreenScene(WINDOW_WIDTH, WINDOW_HEIGHT);

        Scene scene = new Scene(mainScreenScene.getRoot(), WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setTitle("Labs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
