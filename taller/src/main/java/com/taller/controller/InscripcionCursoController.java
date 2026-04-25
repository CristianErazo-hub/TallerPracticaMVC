package com.taller.controller;

import com.taller.modelo.InscripcionCurso;
import com.taller.service.InscripcionCursoService;

import java.util.List;

public class InscripcionCursoController {

    private InscripcionCursoService service;

    public InscripcionCursoController(InscripcionCursoService service) {
        this.service = service;
    }

    public void crear(int idEstudiante, int idGrupo, double notaFinal, String estado) {
        InscripcionCurso i = new InscripcionCurso(0, idEstudiante, idGrupo, notaFinal, estado);
        service.crearInscripcion(i);
    }

    public List<InscripcionCurso> listar() {
        return service.listar();
    }
}