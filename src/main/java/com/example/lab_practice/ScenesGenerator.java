package com.example.lab_practice;

import com.example.lab_practice.FirstLabMainScreen.FirstLabMainScene;
import com.example.lab_practice.MainScreen.MainScreenScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class ScenesGenerator {
    private static ScenesGenerator instance = null;
    private static Stage stage = null;

    private static final double WINDOW_WIDTH = 1440;
    private static final double WINDOW_HEIGHT = 810;

    private Scene mainScreenScene = null;
    private Scene firstLabMainScreenScene = null;

    public Scene getMainScreenScene(){
        if (Objects.isNull(mainScreenScene))
            mainScreenScene = new MainScreenScene(WINDOW_WIDTH, WINDOW_HEIGHT).getRootScene();
        return mainScreenScene;
    }

    public void setMainScreenScene(){
        if (Objects.isNull(mainScreenScene))
            mainScreenScene = new MainScreenScene(WINDOW_WIDTH, WINDOW_HEIGHT).getRootScene();
        stage.setScene(mainScreenScene);
    }

    public Scene getFirstLabMainScreenScene(){
        if (Objects.isNull(firstLabMainScreenScene))
            firstLabMainScreenScene = new FirstLabMainScene(WINDOW_WIDTH, WINDOW_HEIGHT).getRootScene();
        return firstLabMainScreenScene;
    }

    public void setFirstLabMainScreenScene(){
        if (Objects.isNull(firstLabMainScreenScene))
            firstLabMainScreenScene = new FirstLabMainScene(WINDOW_WIDTH, WINDOW_HEIGHT).getRootScene();
        stage.setScene(firstLabMainScreenScene);
    }

    public void setStage(Stage _stage){
        stage = _stage;
    }

    public void setCustomStageScene(Scene scene){
        stage.setScene(scene);
    }

    public static ScenesGenerator getInstance(){
        if (Objects.isNull(instance)) instance = new ScenesGenerator();
        return instance;
    }
}
