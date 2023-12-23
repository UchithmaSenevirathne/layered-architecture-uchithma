module com.example.layeredarchitecture {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;

    opens lk.ijse.layeredarchitecture to javafx.fxml;
    opens lk.ijse.layeredarchitecture.controller to javafx.fxml;
    opens lk.ijse.layeredarchitecture.view.tdm to javafx.base;

    exports lk.ijse.layeredarchitecture;
    exports lk.ijse.layeredarchitecture.controller;
}
