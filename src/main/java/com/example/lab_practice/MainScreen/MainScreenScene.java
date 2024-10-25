package com.example.lab_practice.MainScreen;

import javafx.scene.layout.Pane;

public class MainScreenScene {
    private Pane root;
    private NavigationBreadcrumb navigationBreadcrumb;

    public MainScreenScene(double WINDOW_WIDTH, double WINDOW_HEIGHT) {
        root = new Pane();
        Background background = new Background(WINDOW_WIDTH, WINDOW_HEIGHT);
        RectanglePane rectanglePane = new RectanglePane(WINDOW_WIDTH, WINDOW_HEIGHT);
        ButtonPanel buttonPanel = new ButtonPanel(WINDOW_WIDTH, WINDOW_HEIGHT);
        TextPanel textPanel = new TextPanel(WINDOW_WIDTH, WINDOW_HEIGHT);
        LowerBar lowerBar = new LowerBar(WINDOW_WIDTH, WINDOW_HEIGHT);
        InfoButton infoButton = new InfoButton(1368.75, 708.75);

        // Create and position navigation breadcrumb
        navigationBreadcrumb = new NavigationBreadcrumb();

        root.getChildren().addAll(
                background.getRectangle(),
                rectanglePane.getRectangle(),
                navigationBreadcrumb,
                textPanel.getText(),
                lowerBar,
                infoButton,
                buttonPanel.getButtons()
        );
    }

    public void updateNavigation(String screenName) {
        navigationBreadcrumb.navigateTo(screenName);
    }

    public Pane getRoot() {
        return root;
    }
}