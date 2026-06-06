package com.ucv.lab09.model;

public class EstudiantePreGrado extends Estudiante {
    private String categoria; // A o B
    private double promedioPonderado;
    private String colegioProcedencia; // Estatal o Particular

    // Atributo estático contador para autogenerar código
    private static int contadorPre = 0;

    // Constructor corregido que usa el controlador
    public EstudiantePreGrado(String apellidos, String nombres, String semestreIngreso,
                              String categoria, double promedioPonderado, String colegioProcedencia) {
        // Inicializa los datos comunes de la clase padre Estudiante
        super("", apellidos, nombres, semestreIngreso);
        contadorPre++;
        this.setCodigo(generarCodigoAutogenerado()); // Aplica el método propio solicitado
        this.categoria = categoria;
        this.promedioPonderado = promedioPonderado;
        this.colegioProcedencia = colegioProcedencia;
    }

    // Método propio para autogenerar el código con el formato EPRE0001, EPRE0002...
    private String generarCodigoAutogenerado() {
        return String.format("EPRE%04d", contadorPre);
    }

    // Getters y Setters (Encapsulamiento)
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public double getPromedioPonderado() { return promedioPonderado; }
    public void setPromedioPonderado(double promedioPonderado) { this.promedioPonderado = promedioPonderado; }

    public String getColegioProcedencia() { return colegioProcedencia; }
    public void setColegioProcedencia(String colegioProcedencia) { this.colegioProcedencia = colegioProcedencia; }

    // Implementación real de los métodos abstractos heredados de Estudiante
    @Override
    public double calcularPagoParcial() {
        if (categoria.equalsIgnoreCase("A")) {
            return colegioProcedencia.equalsIgnoreCase("Estatal") ? 320.0 : 450.0;
        } else { // Categoría B
            return colegioProcedencia.equalsIgnoreCase("Estatal") ? 300.0 : 420.0;
        }
    }

    @Override
    public double calcularDescuento() {
        // Si el promedio ponderado es mayor o igual a 13 aplica un 8% (Ajustado según lógica de la guía)
        if (promedioPonderado >= 13.0) {
            return calcularPagoParcial() * 0.08;
        }
        return 0.0; // Menor a 13 es 0%
    }

    // Método recargado para mostrar datos específicos en el TextArea
    @Override
    public String mostrarInfo() {
        return "=== ESTUDIANTE DE PREGRADO ===" + super.mostrarInfo() +
                "\nCategoría\t\t: " + categoria +
                "\nColegio\t\t: " + colegioProcedencia +
                "\nPromedio\t\t: " + promedioPonderado + "\n";
    }
}