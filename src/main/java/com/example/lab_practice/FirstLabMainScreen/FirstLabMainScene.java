package com.example.lab_practice.FirstLabMainScreen;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class FirstLabMainScene {
    private final Scene rootScene;

    public FirstLabMainScene(double width, double height){
        LinearGradient gradient = new LinearGradient(
                0, 0, 1, 1, true, null,
                new Stop(0.19, Color.rgb(255, 144, 0, 0.3)),
                new Stop(0.81, Color.rgb(0, 102, 174, 0.3))
        );
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.setFill(gradient);

        Pane rootPane = new Pane();
        rootPane.getChildren().addAll(rectangle);

        rootScene = new Scene(rootPane, width, height);
    }

    public Scene getRootScene(){
        return rootScene;
    }
}
