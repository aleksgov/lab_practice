module com.example.lab_practice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_practice to javafx.fxml;
    exports com.example.lab_practice;
}