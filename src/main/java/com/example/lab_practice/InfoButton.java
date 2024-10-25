package com.example.lab_practice;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class InfoButton extends Button {
    public InfoButton(double layoutX, double layoutY) {
        super("i");

        setShape(new Circle(50));
        setPrefSize(52.5, 52.5);
        setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.65); " +
                "-fx-font-family: 'Century Gothic'; " +
                "-fx-font-weight: bold; " +
                "-fx-font-size: 36px; " +
                "-fx-text-fill: rgb(79, 79, 79);" +
                "-fx-padding: 0;");

        DropShadow shadow = new DropShadow();
        shadow.setRadius(5.0);
        shadow.setColor(Color.rgb(0, 0, 0, 0.3));
        setEffect(shadow);

        setLayoutX(layoutX);
        setLayoutY(layoutY);

        setOnAction(event -> System.out.println("InfoBox"));
    }
}