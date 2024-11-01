package com.example.lab_practice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.util.HashMap;
import java.util.Map;

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
    Button TheoryLabButton;

    @FXML
    Tab MainTab;

    @FXML
    Tab FirstLabTab;

    @FXML
    Tab TheoryFirstLabTab;

    @FXML
    TabPane TabSystem;

    private Map<Button, Tab> buttonTabMap = new HashMap<>();

    private boolean isColorChanged = false;

    @FXML
    public void initialize() {
        changeColorButton.setOnAction(event -> changeColor());

        buttonTabMap.put(FirstLabButton, FirstLabTab);
        buttonTabMap.put(TheoryLabButton, TheoryFirstLabTab);

        for (var key: buttonTabMap.keySet()){
            key.setOnAction(event -> switchToTab(buttonTabMap.get(key)));
        }

        TabSystem.getTabs().setAll(MainTab);

        TabSystem.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (oldTab != null && newTab != null) {
                handleBackNavigation(newTab);
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
            if (TabSystem.getTabs().getLast() != selectedTab){
                TabSystem.getTabs().removeLast();
            }
            else{
                break;
            }
        }
    }

    private void changeColor() {
        if (isColorChanged) {
            TabSystem.getStylesheets().remove(getClass().getResource("new_color.css").toExternalForm());
        } else {
            TabSystem.getStylesheets().add(getClass().getResource("new_color.css").toExternalForm());
        }
        isColorChanged = !isColorChanged;
    }
}
