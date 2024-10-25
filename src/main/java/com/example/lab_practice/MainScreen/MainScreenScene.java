package com.example.lab_practice.MainScreen;

import javafx.scene.layout.Pane;

public class MainScreenScene {
    private Pane root;

    public MainScreenScene(double WINDOW_WIDTH, double WINDOW_HEIGHT){
        root = new Pane();
        Background background = new Background(WINDOW_WIDTH, WINDOW_HEIGHT);
        RectanglePane rectanglePane = new RectanglePane(WINDOW_WIDTH, WINDOW_HEIGHT);
        ButtonPanel buttonPanel = new ButtonPanel(WINDOW_WIDTH, WINDOW_HEIGHT);
        TextPanel textPanel = new TextPanel(WINDOW_WIDTH, WINDOW_HEIGHT);
        LowerBar lowerBar = new LowerBar(WINDOW_WIDTH, WINDOW_HEIGHT);
        InfoButton infoButton = new InfoButton(1368.75, 708.75);

        root.getChildren().addAll(background.getRectangle(), rectanglePane.getRectangle(),
                textPanel.getText(), lowerBar, infoButton, buttonPanel.getButtons());
    }

    public Pane getRoot(){
        return root;
    }
}
