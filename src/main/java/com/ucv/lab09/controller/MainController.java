package com.ucv.lab09.controller;

import com.ucv.lab09.model.EmpleadoPermanente;
import com.ucv.lab09.model.EmpleadoVendedor;
import com.ucv.lab09.service.IEmpleadoService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    // --- Campos Tab Empleado Vendedor ---
    @FXML private TextField txtDniVendedor;
    @FXML private TextField txtNombresVendedor;
    @FXML private TextField txtApellidosVendedor;
    @FXML private TextField txtTasaComision;
    @FXML private TextField txtMontoVendido;
    @FXML private TextArea  txtAreaVendedor;

    // --- Campos Tab Empleado Permanente ---
    @FXML private TextField txtDniPermanente;
    @FXML private TextField txtApellidosPermanente;
    @FXML private TextField txtNombresPermanente;
    @FXML private TextField txtSueldoBase;
    @FXML private ComboBox<String> cmbAfiliacion;
    @FXML private TextArea  txtAreaPermanente;

    // Servicio inyectado desde MainApplication
    private IEmpleadoService empleadoService;

    public void setEmpleadoService(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @FXML
    public void initialize() {
        cmbAfiliacion.getItems().addAll("AFP", "SNP");
        cmbAfiliacion.setValue("AFP");
    }

    // ---- Acciones Empleado Vendedor ----

    @FXML
    private void onCrearEmpleadoVendedor() {
        try {
            String dni       = txtDniVendedor.getText().trim();
            String nombres   = txtNombresVendedor.getText().trim();
            String apellidos = txtApellidosVendedor.getText().trim();
            double tasa      = Double.parseDouble(txtTasaComision.getText().trim());
            double monto     = Double.parseDouble(txtMontoVendido.getText().trim());

            EmpleadoVendedor vendedor = empleadoService.crearEmpleadoVendedor(
                    dni, apellidos, nombres, monto, tasa);
            txtAreaVendedor.setText(empleadoService.obtenerInformacion(vendedor));
        } catch (NumberFormatException e) {
            txtAreaVendedor.setText("Error: ingrese valores numéricos válidos en Tasa y Monto.");
        }
    }

    @FXML
    private void onBorrarVendedor() {
        txtDniVendedor.clear();
        txtNombresVendedor.clear();
        txtApellidosVendedor.clear();
        txtTasaComision.clear();
        txtMontoVendido.clear();
        txtAreaVendedor.clear();
    }

    // ---- Acciones Empleado Permanente ----

    @FXML
    private void onCrearEmpleadoPermanente() {
        try {
            String dni        = txtDniPermanente.getText().trim();
            String apellidos  = txtApellidosPermanente.getText().trim();
            String nombres    = txtNombresPermanente.getText().trim();
            double sueldoBase = Double.parseDouble(txtSueldoBase.getText().trim());
            String afiliacion = cmbAfiliacion.getValue();

            EmpleadoPermanente permanente = empleadoService.crearEmpleadoPermanente(
                    dni, apellidos, nombres, sueldoBase, afiliacion);
            txtAreaPermanente.setText(empleadoService.obtenerInformacion(permanente));
        } catch (NumberFormatException e) {
            txtAreaPermanente.setText("Error: ingrese un sueldo base numérico válido.");
        }
    }

    @FXML
    private void onBorrarPermanente() {
        txtDniPermanente.clear();
        txtApellidosPermanente.clear();
        txtNombresPermanente.clear();
        txtSueldoBase.clear();
        cmbAfiliacion.setValue("AFP");
        txtAreaPermanente.clear();
    }

    // ---- Acción compartida ----

    @FXML
    private void onSalir() {
        Platform.exit();
    }
}
