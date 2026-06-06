package com.ucv.lab09.model;

public abstract class Empleado {

    private String dni;
    private String apellidos;
    private String nombres;

    public Empleado(String dni, String apellidos, String nombres) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    // Muestra los atributos base del empleado
    public String mostrarInformacion() {
        return "DNI       : " + dni +
               "\nApellidos : " + apellidos +
               "\nNombres   : " + nombres;
    }

    // Métodos abstractos
    public abstract double ingresos();
    public abstract double bonificacion();
    public abstract double descuentos();

    // Sueldo neto (no abstracto)
    public double sueldo() {
        return ingresos() + bonificacion() - descuentos();
    }

    // Impresión completa del empleado (no abstracto)
    public String imprimirInformacion() {
        return mostrarInformacion() +
               "\nIngresos       : S/ " + String.format("%.2f", ingresos()) +
               "\nBonificación   : S/ " + String.format("%.2f", bonificacion()) +
               "\nDescuentos     : S/ " + String.format("%.2f", descuentos()) +
               "\nSueldo Neto    : S/ " + String.format("%.2f", sueldo());
    }
}
