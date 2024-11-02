package com.example.lab_practice;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Pair;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainController {
    @FXML
    Button FirstLabButton;

    @FXML
    Button SecondLabButton;

    @FXML
    Button ThirdLabButton;

    @FXML
    Button FourthLabButton;

    @FXML
    Button infoButton;

    @FXML
    Button changeColorButton;

    @FXML
    Button changeColorButton1;

    @FXML
    VBox colorButtonsContainer;

    @FXML
    Button TheoryLabButton;

    @FXML
    Button ExampleFirstLabButton;

    @FXML
    Tab MainTab;

    @FXML
    Tab FirstLabTab;

    @FXML
    Tab TheoryFirstLabTab;

    @FXML
    Tab ExampleFirstLabTab;

    @FXML
    TabPane TabSystem;

    @FXML
    WebView webView;

    @FXML
    TitledPane firstStep;

    @FXML
    TitledPane secondStep;

    @FXML
    TitledPane thirdStep;

    @FXML
    ScrollPane ScrollExample;


    private Map<Button, Pair<Tab, String>> buttonTabMap = new HashMap<>();

    private Map<Button, String> buttonColorMap = new HashMap<>();
    private Button displayedButton = null;
    private ArrayList<String> styleFiles = new ArrayList<>();

    @FXML
    public void initialize() {
        buttonTabMap.put(FirstLabButton, new Pair<>(FirstLabTab, null));
        buttonTabMap.put(TheoryLabButton, new Pair<>(TheoryFirstLabTab, "Lab1.html"));
        buttonTabMap.put(ExampleFirstLabButton, new Pair<>(ExampleFirstLabTab, null));

        ScrollExample.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        for (var key: buttonTabMap.keySet()){
            key.setOnAction(event -> {
                switchToTab(buttonTabMap.get(key).getKey());
                if (Objects.nonNull(buttonTabMap.get(key).getValue())){
                    WebEngine webEngine = webView.getEngine();
                    URL url = getClass().getResource(buttonTabMap.get(key).getValue());
                    webEngine.setUserStyleSheetLocation(getClass().getResource("css_style/webview.css").toString());
                    webEngine.load(url.toString());
                }
            });
        }

        buttonColorMap.put(changeColorButton, "css_style/blue_yellow.css");
        buttonColorMap.put(changeColorButton1, "css_style/green_orange.css");

        for (var key: buttonColorMap.keySet()){
            if (Objects.isNull(displayedButton)){
                displayedButton = key;
            }

            key.setOnAction(event -> {
                if (colorButtonsContainer.getChildren().size() != 1){
                    displayedButton = key;
                    colorButtonsContainer.getChildren().setAll(key);
                    changeColor(buttonColorMap.get(key));
                    colorButtonsContainer.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                } else if (displayedButton == key) {
                    colorButtonsContainer.getChildren().setAll(buttonColorMap.keySet());
                    colorButtonsContainer.getChildren().remove(key);
                    colorButtonsContainer.getChildren().addFirst(key);
                    colorButtonsContainer.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.65), new CornerRadii(10), Insets.EMPTY)));
                }
            });

            styleFiles.add(buttonColorMap.get(key));
        }

        TabSystem.getTabs().setAll(MainTab);

        TabSystem.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (oldTab != null && newTab != null) {
                handleBackNavigation(newTab);
            }
            if (newTab != null) {
                int index = TabSystem.getTabs().indexOf(newTab);
                if (index > 0) {
                    if (!(TabSystem.getTabs().get(index - 1).getText().equals("→"))) {
                        Tab arrowTab = new Tab("→");
                        arrowTab.getStyleClass().add("tab-arrow");
                        arrowTab.setDisable(true);
                        TabSystem.getTabs().add(index, arrowTab);
                    }
                }
            }
        });
        setupTitledPane(firstStep);
        setupTitledPane(secondStep);
        setupTitledPane(thirdStep);

        changeColorButton.fire();
    }

    private void setupTitledPane(TitledPane titledPane) {
        titledPane.expandedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                titledPane.toFront();
                titledPane.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 0);");
            } else {
                titledPane.setStyle("");
                titledPane.toBack();
            }
        });
    }

    private void switchToTab(Tab newTab) {
        if (!TabSystem.getTabs().contains(newTab)) {
            TabSystem.getTabs().add(newTab);
        }
        TabSystem.getSelectionModel().select(newTab);
    }

    private void handleBackNavigation(Tab selectedTab) {
        while(!TabSystem.getTabs().isEmpty()){
            if (TabSystem.getTabs().getLast() != selectedTab)
                TabSystem.getTabs().removeLast();
            else
                break;
        }
    }

    private void changeColor(String path) {
        for (var file: styleFiles){
            TabSystem.getStylesheets().remove(Objects.requireNonNull(getClass().getResource(file)).toExternalForm());
        }
        TabSystem.getStylesheets().add(Objects.requireNonNull(getClass().getResource(path)).toExternalForm());
    }
}
