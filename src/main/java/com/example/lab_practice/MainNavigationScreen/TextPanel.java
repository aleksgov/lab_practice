package com.example.lab_practice.MainNavigationScreen;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;

public class TextPanel {
    private final Text text;

    public TextPanel(double windowWidth, double windowHeight) {
        text = new Text(" ");
        text.setFill(Color.BLACK);
        text.setFont(new Font("Century Gothic", 36.0));
        //text.setStyle("-fx-font-family: 'Verdana'; -fx-font-size: 36px;");
        text.setTextAlignment(TextAlignment.CENTER);
        text.setBoundsType(TextBoundsType.VISUAL);
        text.applyCss();
    }
    public Text getText() {
        return text;
    }
    public void setText(String str){
        text.setText(str);
    }
}
