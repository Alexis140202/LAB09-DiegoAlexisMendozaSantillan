package com.ucv.lab09.controller;

import com.ucv.lab09.model.Estudiante;
import com.ucv.lab09.model.EstudiantePreGrado;
import com.ucv.lab09.model.EstudiantePostGrado;
import com.ucv.lab09.service.EstudianteService;
import com.ucv.lab09.service.IEstudianteService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    private final IEstudianteService estudianteService = new EstudianteService();

    // --- Componentes de la pestaña: Estudiante Pregrado ---
    @FXML private TextField txtNombresPre;
    @FXML private TextField txtApellidosPre;
    @FXML private ComboBox<String> cmbSemestrePre;
    @FXML private ComboBox<String> cmbCategoriaPre;
    @FXML private ComboBox<String> cmbProcedenciaPre;
    @FXML private TextField txtPromedioPre;
    @FXML private TextArea txtAreaPre;

    // --- Componentes de la pestaña: Estudiante Postgrado ---
    @FXML private TextField txtNombresPos;
    @FXML private TextField txtApellidosPos;
    @FXML private ComboBox<String> cmbSemestrePos;
    @FXML private ComboBox<String> cmbGradoPos;
    @FXML private TextArea txtAreaPos;

    /**
     * Se ejecuta automáticamente al cargar la vista.
     * Llena los ComboBox con las opciones de la guía[cite: 80, 85, 93].
     */
    @FXML
    public void initialize() {
        // Llenar datos de Pregrado
        cmbSemestrePre.getItems().addAll("2010-I", "2011-II");
        cmbCategoriaPre.getItems().addAll("A", "B");
        cmbProcedenciaPre.getItems().addAll("Estatal", "Particular");

        // Llenar datos de Postgrado
        cmbSemestrePos.getItems().addAll("2010-I", "2011-II");
        cmbGradoPos.getItems().addAll("Bachiller", "Titulado");
    }

    // --- TRATAMIENTO DE EXCEPCIONES PARA DATOS NUMÉRICOS ---
    private double validarYLeerPromedio() {
        try {
            String textoPromedio = txtPromedioPre.getText();
            double promedio = Double.parseDouble(textoPromedio);

            // Validación del rango de calificación peruano
            if (promedio < 0 || promedio > 20) {
                throw new IllegalArgumentException("El promedio debe estar entre 0 y 20.");
            }
            return promedio;
        } catch (NumberFormatException e) {
            mostrarAlertaError("Error de Tipo de Dato", "El promedio ponderado debe ser un número válido (Ej: 15.5).");
            return -1;
        } catch (IllegalArgumentException e) {
            mostrarAlertaError("Rango Inválido", e.getMessage());
            return -1;
        }
    }

    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    // --- ACCIONES DE LA PESTAÑA: PREGRADO ---

    @FXML
    void onRegistrarPregrado(ActionEvent event) {
        double promedio = validarYLeerPromedio();
        if (promedio == -1) return;

        String nombres = txtNombresPre.getText();
        String apellidos = txtApellidosPre.getText();
        String semestre = cmbSemestrePre.getValue() != null ? cmbSemestrePre.getValue() : "2010-I";
        String categoria = cmbCategoriaPre.getValue() != null ? cmbCategoriaPre.getValue() : "A";
        String procedencia = cmbProcedenciaPre.getValue() != null ? cmbProcedenciaPre.getValue() : "Estatal";

        if (nombres.isEmpty() || apellidos.isEmpty()) {
            mostrarAlertaError("Campos Vacíos", "Por favor, complete el nombre y apellido del estudiante.");
            return;
        }

        // Creación e inserción en el servicio en memoria [cite: 68, 101]
        Estudiante estPre = new EstudiantePreGrado(apellidos, nombres, semestre, categoria, promedio, procedencia);
        estudianteService.registrarEstudiante(estPre);

        txtAreaPre.appendText(estPre.mostrarInfo());
    }

    @FXML
    void onBorrarPregrado(ActionEvent event) {
        txtNombresPre.clear();
        txtApellidosPre.clear();
        txtPromedioPre.clear();
        cmbSemestrePre.getSelectionModel().clearSelection();
        cmbCategoriaPre.getSelectionModel().clearSelection();
        cmbProcedenciaPre.getSelectionModel().clearSelection();
        txtAreaPre.clear();
    }

    // --- ACCIONES DE LA PESTAÑA: POSTGRADO ---

    @FXML
    void onRegistrarPostgrado(ActionEvent event) {
        String nombres = txtNombresPos.getText();
        String apellidos = txtApellidosPos.getText();
        String semestre = cmbSemestrePos.getValue() != null ? cmbSemestrePos.getValue() : "2010-I";
        String grado = cmbGradoPos.getValue() != null ? cmbGradoPos.getValue() : "Bachiller";

        if (nombres.isEmpty() || apellidos.isEmpty()) {
            mostrarAlertaError("Campos Vacíos", "Por favor, complete el nombre y apellido del estudiante.");
            return;
        }

        // Creación utilizando la clase corregida EstudiantePostGrad [cite: 93, 101]
        Estudiante estPos = new EstudiantePostGrado(apellidos, nombres, semestre, grado);
        estudianteService.registrarEstudiante(estPos);

        txtAreaPos.appendText(estPos.mostrarInfo());
    }

    @FXML
    void onBorrarPostgrado(ActionEvent event) {
        txtNombresPos.clear();
        txtApellidosPos.clear();
        cmbSemestrePos.getSelectionModel().clearSelection();
        cmbGradoPos.getSelectionModel().clearSelection();
        txtAreaPos.clear();
    }

    // --- ACCIÓN COMÚN ---
    @FXML
    void onSalir(ActionEvent event) {
        System.exit(0);
    }
}