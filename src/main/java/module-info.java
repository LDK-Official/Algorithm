module com.example.algorithm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.algorithm to javafx.fxml;
    exports com.example.algorithm;
    exports com.example.algorithm.Etc;
    opens com.example.algorithm.Etc to javafx.fxml;
}