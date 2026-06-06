package com.ucv.lab09;

import com.ucv.lab09.controller.MainController;
import com.ucv.lab09.service.EmpleadoService;
import com.ucv.lab09.service.IEmpleadoService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                MainApplication.class.getResource("/com/ucv/lab09/main-view.fxml"));

        // Inyección de Dependencias: el servicio se crea aquí y se inyecta en el controller
        IEmpleadoService empleadoService = new EmpleadoService();

        fxmlLoader.setControllerFactory(controllerClass -> {
            if (controllerClass == MainController.class) {
                MainController controller = new MainController();
                controller.setEmpleadoService(empleadoService);
                return controller;
            }
            try {
                return controllerClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("No se pudo instanciar el controller: " + controllerClass, e);
            }
        });

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Aplicacion de Herencia: Clases y Subclases");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
