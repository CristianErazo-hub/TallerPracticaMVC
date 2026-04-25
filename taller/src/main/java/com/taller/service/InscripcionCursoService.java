package com.taller.service;

import com.taller.dao.InscripcionCursoDAO;
import com.taller.modelo.InscripcionCurso;

import java.util.List;

public class InscripcionCursoService {

    private InscripcionCursoDAO dao;

    public InscripcionCursoService(InscripcionCursoDAO dao) {
        this.dao = dao;
    }

    public void crearInscripcion(InscripcionCurso inscripcion) {
        dao.crear(inscripcion);
    }

    public List<InscripcionCurso> listar() {
        return dao.listar();
    }
}