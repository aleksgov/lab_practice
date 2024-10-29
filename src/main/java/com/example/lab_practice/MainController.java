package com.example.lab_practice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
    Button TheoryLabButton;

    @FXML
    Tab MainTab;

    @FXML
    Tab FirstLabTab;

    @FXML
    Tab TheoryFirstLabTab;

    @FXML
    TabPane TabSystem;

    private Stack<Tab> tabStack = new Stack<>();
    private Map<Button, Tab> buttonTabMap = new HashMap<>();

    @FXML
    public void initialize() {

        buttonTabMap.put(FirstLabButton, FirstLabTab);
        buttonTabMap.put(TheoryLabButton, TheoryFirstLabTab);

        FirstLabButton.setOnAction(event -> switchToTab(FirstLabTab));
        TheoryLabButton.setOnAction(event -> switchToTab(TheoryFirstLabTab));

        for (int i = TabSystem.getTabs().size() - 1; i >= 0; i--) {
            Tab tab = TabSystem.getTabs().get(i);
            if (tab != MainTab) {
                TabSystem.getTabs().remove(tab);
            }
        }

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
        tabStack.push(newTab);
        TabSystem.getSelectionModel().select(newTab);
    }

    private void handleBackNavigation(Tab selectedTab) {
        while (!tabStack.isEmpty()) {
            Tab currentTab = tabStack.peek();
            if (currentTab != selectedTab) {
                tabStack.pop();
                TabSystem.getTabs().remove(currentTab);
            } else {
                break;
            }
        }
        tabStack.push(selectedTab);
    }

}
