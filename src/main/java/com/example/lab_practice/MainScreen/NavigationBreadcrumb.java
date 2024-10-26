package com.example.lab_practice.MainScreen;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class NavigationBreadcrumb extends VBox {
    private HBox breadcrumbContainer;
    private Label mainLabel;
    private Label currentScreenLabel;

    public NavigationBreadcrumb() {
        breadcrumbContainer = new HBox(10);
        breadcrumbContainer.setPadding(new Insets(14, 0, 10, 22));

        mainLabel = createNavigationLabel("Главная");
        mainLabel.getStyleClass().add("active");
        mainLabel.setOnMouseClicked(event -> navigateTo("Главная"));
        breadcrumbContainer.getChildren().add(mainLabel);

        String stylesheets = Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm();
        breadcrumbContainer.getStylesheets().add(stylesheets);

        getChildren().add(breadcrumbContainer);
    }

    private Label createNavigationLabel(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Century Gothic", 21));
        return label;
    }

    public void navigateTo(String screenName) {
        breadcrumbContainer.getChildren().clear();
        mainLabel = createNavigationLabel("Главная");
        mainLabel.getStyleClass().add("active");
        mainLabel.setOnMouseClicked(event -> navigateTo("Главная"));
        breadcrumbContainer.getChildren().add(mainLabel);

        if (!screenName.equals("Главная")) {
            Label arrow = createNavigationLabel("→");
            arrow.setPadding(new Insets(0, 5, 0, 5));

            currentScreenLabel = createNavigationLabel(screenName);
            currentScreenLabel.getStyleClass().add("active");

            breadcrumbContainer.getChildren().addAll(arrow, currentScreenLabel);
        } else {
            if (currentScreenLabel != null) {
                currentScreenLabel.getStyleClass().remove("active");
            }
        }
    }

    public void addNavigationLevel(String screenName) {
        Label arrow = createNavigationLabel("→");
        arrow.setPadding(new Insets(0, 5, 0, 5));

        currentScreenLabel = createNavigationLabel(screenName);
        currentScreenLabel.getStyleClass().add("active");

        breadcrumbContainer.getChildren().addAll(arrow, currentScreenLabel);
    }
}
