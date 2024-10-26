package com.example.lab_practice;

import com.example.lab_practice.MainNavigationScreen.MainNavigationScreenScene;
import com.example.lab_practice.TextScreen.TextScreenScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Objects;

public class ScenesGenerator {
    private static ScenesGenerator instance = null;
    private static Stage stage = null;

    private static final double WINDOW_WIDTH = 1440;
    private static final double WINDOW_HEIGHT = 810;

    private MainNavigationScreenScene mainNavigationScreenScene = null;
    private TextScreenScene textScreenScene = null;

    public Scene getMainScreenScene(){
        if (Objects.isNull(mainNavigationScreenScene))
            mainNavigationScreenScene = new MainNavigationScreenScene(WINDOW_WIDTH, WINDOW_HEIGHT);
        mainNavigationScreenScene.setToMainScreenState();
        return mainNavigationScreenScene.getRootScene();
    }

    public Scene getFirstLabMainScreenScene(){
        if (Objects.isNull(mainNavigationScreenScene))
            mainNavigationScreenScene = new MainNavigationScreenScene(WINDOW_WIDTH, WINDOW_HEIGHT);
        mainNavigationScreenScene.setToFirstLabMainScreenState();
        return mainNavigationScreenScene.getRootScene();
    }

    public Scene getTextScreenScene(){
        if (Objects.isNull(textScreenScene))
            textScreenScene = new TextScreenScene(WINDOW_WIDTH, WINDOW_HEIGHT);
        textScreenScene.setText("/Texts/1_lab_text.html");
        return textScreenScene.getRootScene();
    }

    public void setStage(Stage _stage){
        stage = _stage;
    }

    public void setStageScene(Scene scene){
        stage.setScene(scene);
    }

    public static ScenesGenerator getInstance(){
        if (Objects.isNull(instance)) instance = new ScenesGenerator();
        return instance;
    }
}
