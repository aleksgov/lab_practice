package com.example.lab_practice.MainScreen;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ButtonPanel {
    private Pane buttons;

    public ButtonPanel(double windowWidth, double windowHeight) {
        buttons = new Pane();
        double buttonWidth = 277.5;
        double buttonHeight = 112.5;
        double spacingX = 37.5;
        double spacingY = 37.5;

        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(0);
        shadow.setOffsetY(0);
        shadow.setRadius(6);
        shadow.setSpread(0.2);
        shadow.setColor(Color.rgb(0, 0, 0, 0.25));

        double startX = (windowWidth - 2 * buttonWidth - spacingX) / 2;
        double startY = (windowHeight - 2 * buttonHeight - spacingY) / 1.6 ;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Button button = new Button((i * 2 + j + 1) + "");
                button.setPrefSize(buttonWidth, buttonHeight);
                button.setStyle(
                        "-fx-background-color: rgba(255, 255, 255, 1); " +
                        "-fx-font-family: 'Century Gothic'; " +
                        "-fx-font-size: 72px; " +
                        "-fx-text-fill: black; " +
                        "-fx-background-radius: 30px;" +
                        "-fx-padding: 0 165 0 0;");
                button.setLayoutX(startX + j * (buttonWidth + spacingX));
                button.setLayoutY(startY + i * (buttonHeight + spacingY));
                button.setEffect(shadow);

                buttons.getChildren().add(button);
            }
        }
    }

    public Pane getButtons() {
        return buttons;
    }
}
