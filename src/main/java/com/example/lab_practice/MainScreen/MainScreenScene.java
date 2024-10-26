package com.example.lab_practice.MainScreen;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MainScreenScene {
    private final Scene rootScene;
    private final NavigationBreadcrumb navigationBreadcrumb;

    public MainScreenScene(double WINDOW_WIDTH, double WINDOW_HEIGHT) {
        Pane rootPane = new Pane();
        Background background = new Background(WINDOW_WIDTH, WINDOW_HEIGHT);
        RectanglePane rectanglePane = new RectanglePane(WINDOW_WIDTH, WINDOW_HEIGHT);
        ButtonPanel buttonPanel = new ButtonPanel(WINDOW_WIDTH, WINDOW_HEIGHT);
        TextPanel textPanel = new TextPanel(WINDOW_WIDTH, WINDOW_HEIGHT);
        LowerBar lowerBar = new LowerBar(WINDOW_WIDTH, WINDOW_HEIGHT);
        InfoButton infoButton = new InfoButton(1368.75, 708.75);

        // Create and position navigation breadcrumb
        navigationBreadcrumb = new NavigationBreadcrumb();

        rootPane.getChildren().addAll(
                background.getRectangle(),
                rectanglePane.getRectangle(),
                navigationBreadcrumb,
                textPanel.getText(),
                lowerBar,
                infoButton,
                buttonPanel.getButtons()
        );

        rootScene = new Scene(rootPane, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    public void updateNavigation(String screenName) {
        navigationBreadcrumb.navigateTo(screenName);
    }

    public Scene getRootScene() {
        return rootScene;
    }
}