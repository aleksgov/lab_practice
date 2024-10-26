package com.example.lab_practice.TextScreen;

import com.example.lab_practice.MainNavigationScreen.*;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.Objects;

public class TextScreenScene {
    private Scene rootScene;
    private final NavigationBreadcrumb navigationBreadcrumb;
    private final Pane rootPane;

    private double windowWidth;
    private double windowHeight;

    public Background background;
    public LowerBar lowerBar;

    public TextScreenScene(double WINDOW_WIDTH, double WINDOW_HEIGHT) {
        windowWidth = WINDOW_WIDTH;
        windowHeight = WINDOW_HEIGHT;
        rootPane = new Pane();
        rootScene = new Scene(rootPane, windowWidth, windowHeight);
        background = new Background(WINDOW_WIDTH, WINDOW_HEIGHT);
        lowerBar = new LowerBar(WINDOW_WIDTH, WINDOW_HEIGHT);
        navigationBreadcrumb = new NavigationBreadcrumb();

        rootPane.getChildren().setAll(
                background.getRectangle(),
                navigationBreadcrumb,
                lowerBar
        );
    }

    public void setText(String path){

        URL url = Objects.requireNonNull(getClass().getResource(path));

        WebView webView = new WebView();
        webView.getEngine().load(url.toString());

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(webView);
        scrollPane.resize(800, windowHeight - 125);
        scrollPane.setLayoutX(windowWidth / 2 - 400);
        scrollPane.setLayoutY(125);

        rootPane.getChildren().add(scrollPane);
    }

    public void updateNavigation(String screenName) {
        navigationBreadcrumb.navigateTo(screenName);
    }

    public Scene getRootScene() {
        return rootScene;
    }
}
