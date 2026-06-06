package com.ucv.lab09.service;

import com.ucv.lab09.model.Estudiante;
import java.util.List;

public interface IEstudianteService {
    void registrarEstudiante(Estudiante estudiante);
    List<Estudiante> obtenerTodos();
    void limpiarLista();
}