module com.example.labb3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.labb3 to javafx.fxml;
    exports com.example.labb3;
    exports com.example.labb3.Model;
    opens com.example.labb3.Model to javafx.fxml;
}