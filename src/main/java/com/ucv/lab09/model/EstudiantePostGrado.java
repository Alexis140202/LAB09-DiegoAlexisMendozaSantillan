package com.ucv.lab09.model;

public class EstudiantePostGrado extends Estudiante {
    private String gradoAcademico; // Bachiller o Titulado

    // Atributo estático contador para autogenerar código
    private static int contadorPost = 0;

    // Constructor que invoca tu MainController
    public EstudiantePostGrado(String apellidos, String nombres, String semestreIngreso, String gradoAcademico) {
        super("", apellidos, nombres, semestreIngreso);
        contadorPost++;
        this.setCodigo(generarCodigoAutogenerado());
        this.gradoAcademico = gradoAcademico;
    }

    // Método propio para autogenerar el código EPOS0001, EPOS0002...
    private String generarCodigoAutogenerado() {
        return String.format("EPOS%04d", contadorPost);
    }

    // Getters y Setters (Encapsulamiento)
    public String getGradoAcademico() { return gradoAcademico; }
    public void setGradoAcademico(String gradoAcademico) { this.gradoAcademico = gradoAcademico; }

    // Implementación de pagos de Postgrado según la tabla de la guía
    @Override
    public double calcularPagoParcial() {
        return gradoAcademico.equalsIgnoreCase("Bachiller") ? 400.0 : 350.0;
    }

    @Override
    public double calcularDescuento() {
        return 0.0; // Postgrado no goza de descuentos según la guía
    }

    // Método recargado para mostrar datos específicos
    @Override
    public String mostrarInfo() {
        return "=== ESTUDIANTE DE POSTGRADO ===" + super.mostrarInfo() +
                "\nGrado Académico\t: " + gradoAcademico + "\n";
    }
}