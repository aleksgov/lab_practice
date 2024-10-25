package com.example.lab_practice;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LowerBar extends Region {
    private Rectangle lowerBar;

    public LowerBar(double width, double height) {
        lowerBar = new Rectangle(width, height);
        lowerBar.setFill(Color.rgb(136, 136, 136, 1));
        lowerBar.setY(height - 30);

        getChildren().add(lowerBar);
    }
}
