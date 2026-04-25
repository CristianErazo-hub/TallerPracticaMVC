package com.taller.dao;

import java.util.List;
import com.taller.modelo.InscripcionCurso;

public interface InscripcionCursoDAO {

    void crear(InscripcionCurso inscripcion);
    InscripcionCurso obtener(int id);
    List<InscripcionCurso> listar();
    void actualizar(InscripcionCurso inscripcion);
    void eliminar(int id);
}