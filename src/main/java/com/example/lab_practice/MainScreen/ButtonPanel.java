package com.example.lab_practice.MainScreen;

import com.example.lab_practice.commands.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.util.HashMap;
import java.util.Map;

public class ButtonPanel {
    private final Pane buttons;
    private final Map<Integer, Command> buttonCommands;

    public ButtonPanel(double windowWidth, double windowHeight) {
        buttons = new Pane();
        // Инициализация команд для кнопок (пока что пусто)
        buttonCommands = new HashMap<>();
        buttonCommands.put(1, new FirstButtonCommand());
        buttonCommands.put(2, new SecondButtonCommand());
        buttonCommands.put(3, new ThirdButtonCommand());
        buttonCommands.put(4, new FourthButtonCommand());

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
        double startY = (windowHeight - 2 * buttonHeight - spacingY) / 1.6;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Button button = new Button();
                HBox buttonContent = new HBox(20);
                buttonContent.setAlignment(Pos.CENTER_LEFT);

                // Цифра
                Text numberText = new Text((i * 2 + j + 1) + "");
                numberText.setStyle("-fx-font-family: 'Century Gothic'; -fx-font-size: 72px;");

                // Контейнер для текста справа
                VBox rightText = new VBox(5);
                rightText.setAlignment(Pos.CENTER_LEFT);

                Text labText1 = new Text("Лабораторная");
                Text labText2 = new Text("работа");
                labText1.setStyle("-fx-font-family: 'Century Gothic'; -fx-font-size: 24px;");
                labText2.setStyle("-fx-font-family: 'Century Gothic'; -fx-font-size: 24px;");

                rightText.getChildren().addAll(labText1, labText2);
                buttonContent.getChildren().addAll(numberText, rightText);
                button.setGraphic(buttonContent);

                button.setPrefSize(buttonWidth, buttonHeight);
                button.setStyle(
                        "-fx-background-color: rgba(255, 255, 255, 1); " +
                                "-fx-background-radius: 30px; " +
                                "-fx-padding: 10 20 10 30;");
                button.setLayoutX(startX + j * (buttonWidth + spacingX));
                button.setLayoutY(startY + i * (buttonHeight + spacingY));
                button.setEffect(shadow);

                final int buttonNumber = i * 2 + j + 1;
                button.setOnAction(event -> executeCommand(buttonNumber));

                buttons.getChildren().add(button);
            }
        }
    }

    private void executeCommand(int buttonNumber) {
        Command command = buttonCommands.get(buttonNumber);
        if (command != null) {
            command.execute();
        }
    }

    public Pane getButtons() {
        return buttons;
    }
}