package com.example.lab_practice.MainNavigationScreen;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainNavigationScreenScene {
    private Scene rootScene;
    private final NavigationBreadcrumb navigationBreadcrumb;
    private final Pane rootPane;

    private double windowWidth;
    private double windowHeight;

    public Background background;
    public RectanglePane rectanglePane;
    public ButtonPanel buttonPanel;
    public TextPanel textPanel;
    public LowerBar lowerBar;
    public InfoButton infoButton;

    public MainNavigationScreenScene(double WINDOW_WIDTH, double WINDOW_HEIGHT) {
        windowWidth = WINDOW_WIDTH;
        windowHeight = WINDOW_HEIGHT;
        rootPane = new Pane();
        rootScene = new Scene(rootPane, windowWidth, windowHeight);
        background = new Background(WINDOW_WIDTH, WINDOW_HEIGHT);
        rectanglePane = new RectanglePane(WINDOW_WIDTH, WINDOW_HEIGHT, 975, 562.5);
        buttonPanel = new ButtonPanel(WINDOW_WIDTH, WINDOW_HEIGHT);
        textPanel = new TextPanel(WINDOW_WIDTH, WINDOW_HEIGHT);
        lowerBar = new LowerBar(WINDOW_WIDTH, WINDOW_HEIGHT);
        infoButton = new InfoButton(1368.75, 708.75);
        navigationBreadcrumb = new NavigationBreadcrumb();
    }

    public void setToMainScreenState(){
        textPanel.setText("Лабораторный практикум\nпо предмету “Управление данными”");
        double textWidth = textPanel.getText().getLayoutBounds().getWidth();
        textPanel.getText().setX((windowWidth - textWidth) / 2);
        textPanel.getText().setY(windowHeight / 3.5);

        rootPane.getChildren().setAll(
                background.getRectangle(),
                rectanglePane.getRectangle(),
                navigationBreadcrumb,
                textPanel.getText(),
                lowerBar,
                infoButton,
                buttonPanel.getButtons()
        );

        //update();
    }

    public void setToFirstLabMainScreenState(){
        //textPanel = new TextPanel(window_width, window_height);
        textPanel.setText("Лабораторная работа №1");
        double textWidth = textPanel.getText().getLayoutBounds().getWidth();
        textPanel.getText().setX((windowWidth - textWidth) / 2 );
        textPanel.getText().setY(windowHeight / 3.5);

        rootPane.getChildren().setAll(
                background.getRectangle(),
                rectanglePane.getRectangle(),
                navigationBreadcrumb,
                textPanel.getText(),
                lowerBar,
                infoButton,
                buttonPanel.getButtons()
        );

        //update();
    }

    public void update(){
        rootScene.setRoot(rootPane);
        //rootScene = new Scene(rootPane, window_width, window_width);
    }

    public void updateNavigation(String screenName) {
        navigationBreadcrumb.navigateTo(screenName);
    }

    public Scene getRootScene() {
        return rootScene;
    }
}