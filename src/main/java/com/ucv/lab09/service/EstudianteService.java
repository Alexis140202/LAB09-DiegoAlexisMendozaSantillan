package com.ucv.lab09.service;

import com.ucv.lab09.model.Estudiante;
import java.util.ArrayList;
import java.util.List;

public class EstudianteService implements IEstudianteService {

    // Lista en memoria para almacenar los estudiantes de Pregrado y Postgrado
    private final List<Estudiante> listaEstudiantes;

    // Constructor
    public EstudianteService() {
        this.listaEstudiantes = new ArrayList<>();
    }

    @Override
    public void registrarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            listaEstudiantes.add(estudiante);
        }
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        return new ArrayList<>(listaEstudiantes);
    }

    @Override
    public void limpiarLista() {
        listaEstudiantes.clear();
    }
}