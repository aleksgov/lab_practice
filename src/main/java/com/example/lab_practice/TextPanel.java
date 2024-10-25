package com.example.lab_practice;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;

public class TextPanel {
    private Text text;

    public TextPanel(double windowWidth, double windowHeight) {
        text = new Text("Лабораторный практикум\nпо предмету “Управление данными”");
        text.setFill(Color.BLACK);
        text.setStyle("-fx-font-family: 'Century Gothic'; -fx-font-size: 36px;");
        text.setTextAlignment(TextAlignment.CENTER);
        text.setBoundsType(TextBoundsType.VISUAL);

        double textWidth = text.getLayoutBounds().getWidth();
        text.setX((windowWidth - textWidth) / 3.2);
        text.setY(windowHeight / 3.5);
    }
    public Text getText() {
        return text;
    }
}
