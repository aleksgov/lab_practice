package com.example.lab_practice;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectanglePane {
    private Rectangle rectangle;

    public RectanglePane(double windowWidth, double windowHeight) {
        rectangle = new Rectangle(975, 562.5);
        rectangle.setFill(Color.rgb(255, 255, 255, 0.34));
        rectangle.setArcWidth(60);
        rectangle.setArcHeight(60);

        double centerX = (windowWidth - rectangle.getWidth()) / 2;
        double centerY = (windowHeight - rectangle.getHeight()) / 2;
        rectangle.setX(centerX);
        rectangle.setY(centerY);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
