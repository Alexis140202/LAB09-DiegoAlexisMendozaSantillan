package com.ucv.lab09.service;

import com.ucv.lab09.model.Empleado;
import com.ucv.lab09.model.EmpleadoPermanente;
import com.ucv.lab09.model.EmpleadoVendedor;
// aa
public class EmpleadoService implements IEmpleadoService {

    @Override
    public EmpleadoVendedor crearEmpleadoVendedor(String dni, String apellidos, String nombres,
                                                   double montoVendido, double tasaComision) {
        return new EmpleadoVendedor(dni, apellidos, nombres, montoVendido, tasaComision);
    }

    @Override
    public EmpleadoPermanente crearEmpleadoPermanente(String dni, String apellidos, String nombres,
                                                       double sueldoBase, String afiliacion) {
        return new EmpleadoPermanente(dni, apellidos, nombres, sueldoBase, afiliacion);
    }

    @Override
    public String obtenerInformacion(Empleado empleado) {
        return empleado.imprimirInformacion();
    }
}
