package com.ucv.lab09.model;

public class EmpleadoPermanente extends Empleado {

    private double sueldoBase;
    private String afiliacion; // AFP o SNP

    public EmpleadoPermanente(String dni, String apellidos, String nombres,
                               double sueldoBase, String afiliacion) {
        super(dni, apellidos, nombres);
        this.sueldoBase = sueldoBase;
        this.afiliacion = afiliacion;
    }

    // Getters y Setters
    public double getSueldoBase() { return sueldoBase; }
    public void setSueldoBase(double sueldoBase) { this.sueldoBase = sueldoBase; }

    public String getAfiliacion() { return afiliacion; }
    public void setAfiliacion(String afiliacion) { this.afiliacion = afiliacion; }

    @Override
    public double ingresos() {
        return sueldoBase;
    }

    @Override
    public double bonificacion() {
        return 0;
    }

    @Override
    public double descuentos() {
        if (afiliacion.equalsIgnoreCase("AFP")) {
            return sueldoBase * 0.15;
        } else {
            return sueldoBase * 0.11;
        }
    }

    public double asignacionMovilidad() {
        return ingresos() < 1000 ? 50.0 : 40.0;
    }

    @Override
    public double sueldo() {
        return ingresos() - descuentos() + asignacionMovilidad();
    }

    @Override
    public String imprimirInformacion() {
        return mostrarInformacion() +
               "\nSueldo Base      : S/ " + String.format("%.2f", sueldoBase) +
               "\nAfiliación       : " + afiliacion +
               "\nIngresos         : S/ " + String.format("%.2f", ingresos()) +
               "\nDescuentos       : S/ " + String.format("%.2f", descuentos()) +
               "\nAsig. Movilidad  : S/ " + String.format("%.2f", asignacionMovilidad()) +
               "\nSueldo Neto      : S/ " + String.format("%.2f", sueldo());
    }
}
