package com.example.lab_practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private static final double WINDOW_WIDTH = 1440;
    private static final double WINDOW_HEIGHT = 810;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Background background = new Background(WINDOW_WIDTH, WINDOW_HEIGHT);
        RectanglePane rectanglePane = new RectanglePane(WINDOW_WIDTH, WINDOW_HEIGHT);
        ButtonPanel buttonPanel = new ButtonPanel(WINDOW_WIDTH, WINDOW_HEIGHT);
        TextPanel textPanel = new TextPanel(WINDOW_WIDTH, WINDOW_HEIGHT);
        LowerBar lowerBar = new LowerBar(WINDOW_WIDTH, WINDOW_HEIGHT);
        InfoButton infoButton = new InfoButton(1368.75, 708.75);

        root.getChildren().addAll(background.getRectangle(), rectanglePane.getRectangle(),
                textPanel.getText(), lowerBar, infoButton, buttonPanel.getButtons());

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setTitle("Labs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
