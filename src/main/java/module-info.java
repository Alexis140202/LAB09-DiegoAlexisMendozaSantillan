module com.ucv.lab09 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.ucv.lab09            to javafx.fxml;
    opens com.ucv.lab09.controller to javafx.fxml;
    opens com.ucv.lab09.model      to javafx.fxml;

    exports com.ucv.lab09;
    exports com.ucv.lab09.model;
    exports com.ucv.lab09.service;
    exports com.ucv.lab09.controller;
}
