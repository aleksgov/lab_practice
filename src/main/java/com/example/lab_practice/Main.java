package com.example.lab_practice;

import com.example.lab_practice.MainScreen.MainScreenScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        ScenesGenerator scenesGenerator = ScenesGenerator.getInstance();
        scenesGenerator.setStage(primaryStage);

        primaryStage.setTitle("Labs");
        primaryStage.setScene(scenesGenerator.getMainScreenScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
