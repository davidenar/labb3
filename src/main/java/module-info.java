module com.example.labb3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.labb3 to javafx.fxml;
    exports com.example.labb3;
    exports com.example.labb3.model;
    opens com.example.labb3.model to javafx.fxml;
}