package com.ucv.lab09;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Carga el archivo FXML desde la carpeta de recursos
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));

        // Configuramos la escena con las dimensiones de tu FXML (530x450)
        Scene scene = new Scene(fxmlLoader.load(), 530, 450);

        // Título de la ventana según el nuevo ejercicio propuesto
        stage.setTitle("Gestión de Pensiones - Estudiantes UCV");
        stage.setScene(scene);
        stage.setResizable(false); // Mantiene fijo el tamaño de la ventana
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}