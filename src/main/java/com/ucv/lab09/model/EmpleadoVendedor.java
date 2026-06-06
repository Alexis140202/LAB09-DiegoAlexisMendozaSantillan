package com.ucv.lab09.model;

public class EmpleadoVendedor extends Empleado {

    private double montoVendido;
    private double tasaComision;

    public EmpleadoVendedor(String dni, String apellidos, String nombres,
                             double montoVendido, double tasaComision) {
        super(dni, apellidos, nombres);
        this.montoVendido = montoVendido;
        this.tasaComision = tasaComision;
    }

    // Getters y Setters
    public double getMontoVendido() { return montoVendido; }
    public void setMontoVendido(double montoVendido) { this.montoVendido = montoVendido; }

    public double getTasaComision() { return tasaComision; }
    public void setTasaComision(double tasaComision) { this.tasaComision = tasaComision; }

    @Override
    public double ingresos() {
        return montoVendido * tasaComision;
    }

    @Override
    public double bonificacion() {
        double ing = ingresos();
        if (montoVendido < 1000) {
            return 0;
        } else if (montoVendido <= 5000) {
            return ing * 0.05;
        } else {
            return ing * 0.10;
        }
    }

    @Override
    public double descuentos() {
        double ing = ingresos();
        if (ing < 1000) {
            return ing * 0.11;
        } else {
            return ing * 0.15;
        }
    }

    @Override
    public String imprimirInformacion() {
        return mostrarInformacion() +
               "\nMonto Vendido  : S/ " + String.format("%.2f", montoVendido) +
               "\nTasa Comisión  : " + String.format("%.2f", tasaComision) +
               "\nIngresos       : S/ " + String.format("%.2f", ingresos()) +
               "\nBonificación   : S/ " + String.format("%.2f", bonificacion()) +
               "\nDescuentos     : S/ " + String.format("%.2f", descuentos()) +
               "\nSueldo Neto    : S/ " + String.format("%.2f", sueldo());
    }
}
