package com.ucv.lab09.model;

import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class Estudiante implements Serializable {
    // Colocamos la constante solicitada directamente aquí adentro
    public static final double PORCENTAJE_IGV = 0.19;

    private String codigo;
    private String apellidos;
    private String nombres;
    private String semestreIngreso;

    // Constructor
    public Estudiante(String codigo, String apellidos, String nombres, String semestreIngreso) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.semestreIngreso = semestreIngreso;
    }

    // Métodos Getter y Setter (Encapsulamiento)
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getSemestreIngreso() { return semestreIngreso; }
    public void setSemestreIngreso(String semestreIngreso) { this.semestreIngreso = semestreIngreso; }

    // Métodos Abstractos
    public abstract double calcularPagoParcial();
    public abstract double calcularDescuento();

    // Método No Abstracto: Pago Final
    public double calcularPagoFinal() {
        return calcularPagoParcial() - calcularDescuento();
    }

    // Método base para mostrar la información básica
    public String mostrarInfo() {
        DecimalFormat df = new DecimalFormat("###0.00");
        return "\nCódigo\t\t: " + codigo +
                "\nNombres\t\t: " + nombres +
                "\nApellidos\t\t: " + apellidos +
                "\nSemestre\t\t: " + semestreIngreso +
                "\nPago Parcial\t: S/. " + df.format(calcularPagoParcial()) +
                "\nDescuento\t\t: S/. " + df.format(calcularDescuento()) +
                "\nPago Final\t\t: S/. " + df.format(calcularPagoFinal());
    }
}