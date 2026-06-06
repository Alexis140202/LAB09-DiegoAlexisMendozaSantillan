package com.ucv.lab09.service;

import com.ucv.lab09.model.Empleado;
import com.ucv.lab09.model.EmpleadoPermanente;
import com.ucv.lab09.model.EmpleadoVendedor;

public interface IEmpleadoService {

    EmpleadoVendedor crearEmpleadoVendedor(String dni, String apellidos, String nombres,
                                            double montoVendido, double tasaComision);

    EmpleadoPermanente crearEmpleadoPermanente(String dni, String apellidos, String nombres,
                                               double sueldoBase, String afiliacion);

    String obtenerInformacion(Empleado empleado);
}
