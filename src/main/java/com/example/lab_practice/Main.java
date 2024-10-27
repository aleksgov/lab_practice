package com.example.lab_practice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        Parent root = loader.load();

        TabPane tabPane = (TabPane) root.lookup("#TabSystem");

        for (Tab tab : tabPane.getTabs()) {
            Text tabText = new Text(tab.getText());
            tab.setGraphic(tabText);
            tab.setText("");

            if (tab == tabPane.getTabs().get(0)) {
                tabText.setUnderline(true);
                tab.setClosable(false);
            }
        }

        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (oldTab != null && oldTab.getGraphic() instanceof Text) {
                ((Text) oldTab.getGraphic()).setUnderline(false);
            }
            if (newTab != null && newTab.getGraphic() instanceof Text) {
                ((Text) newTab.getGraphic()).setUnderline(true);
            }
        });

        primaryStage.setTitle("TabPane Example");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
