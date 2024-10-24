package com.example.lab_practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {

        double windowWidth = 1440;
        double windowHeight = 810;

        LinearGradient gradient = new LinearGradient(
                0, 0,
                1, 1,
                true,
                null,
                new Stop(0.19, Color.rgb(255, 144, 0, 0.3)),
                new Stop(0.81, Color.rgb(0, 102, 174, 0.3))
        );

        // Корневой контейнер
        Pane root = new Pane();

        // Фон с градиентом
        Rectangle background = new Rectangle(windowWidth, windowHeight);
        background.setFill(gradient);

        // Прямоугольник
        Rectangle roundedRectangle = new Rectangle(975, 562.5);
        roundedRectangle.setFill(Color.rgb(255, 255, 255, 0.34));
        roundedRectangle.setArcWidth(60);
        roundedRectangle.setArcHeight(60);
        double centerX = (windowWidth - roundedRectangle.getWidth()) / 2;
        double centerY = (windowHeight - roundedRectangle.getHeight()) / 2;
        roundedRectangle.setX(centerX);
        roundedRectangle.setY(centerY);

        Text labText = new Text("Лабораторный практикум\nпо предмету “Управление данными”");
        labText.setFill(Color.BLACK);
        labText.setStyle("-fx-font-family: 'Century Gothic'; -fx-font-size: 36px;");
        labText.setTextAlignment(TextAlignment.CENTER);
        labText.setBoundsType(TextBoundsType.VISUAL);
        double textWidth = labText.getLayoutBounds().getWidth();
        labText.setX(centerX + (roundedRectangle.getWidth() - textWidth) / 6 + 25); // Разобраться с координатами
        labText.setY(centerY + 100);

        // Нижняя панель
        Rectangle lowerBar = new Rectangle(windowWidth, 30);
        lowerBar.setFill(Color.rgb(136, 136, 136, 1));
        lowerBar.setY(780);

        // Добавление элементов в корневой контейнер
        root.getChildren().addAll(background, roundedRectangle, lowerBar, labText);

        double buttonWidth = 277.5;
        double buttonHeight = 112.5;
        double spacingX = 37.5;
        double spacingY = 37.5;

        // Вычисление начальных координат для размещения маленьких кнопок
        double startX = centerX + (roundedRectangle.getWidth() - 2 * buttonWidth - spacingX) / 2;
        double startY = centerY + (roundedRectangle.getHeight() - 2 * buttonHeight - spacingY) / 1.4;

        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(0);
        shadow.setOffsetY(0);
        shadow.setRadius(6);
        shadow.setColor(Color.rgb(0, 0, 0, 0.25));

        // Создание и добавление маленьких кнопок в сетке 2 на 2
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Button button = new Button((i * 2 + j + 1) + ""); // Нумерация 1, 2, 3, 4
                button.setPrefSize(buttonWidth, buttonHeight);
                button.setStyle("-fx-background-color: rgba(255, 255, 255, 1); " +
                        "-fx-font-family: 'Century Gothic'; " +
                        "-fx-font-size: 72px; " +
                        "-fx-text-fill: black; " +
                        "-fx-background-radius: 30px;" +
                        "-fx-padding: 0 165 0 0;");
                // Установка координат кнопки
                button.setLayoutX(startX + j * (buttonWidth + spacingX));
                button.setLayoutY(startY + i * (buttonHeight + spacingY));

                button.setEffect(shadow);
                root.getChildren().add(button);
            }
        }

        // Сцена
        Scene scene = new Scene(root, windowWidth, windowHeight);
        primaryStage.setTitle("Labs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
