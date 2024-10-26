package com.example.lab_practice.MainNavigationScreen;

import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class Background {
    private Rectangle rectangle;

    public Background(double width, double height) {
        LinearGradient gradient = new LinearGradient(
                0, 0, 1, 1, true, null,
                new Stop(0.19, Color.rgb(255, 144, 0, 0.3)),
                new Stop(0.81, Color.rgb(0, 102, 174, 0.3))
        );
        rectangle = new Rectangle(width, height);
        rectangle.setFill(gradient);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
