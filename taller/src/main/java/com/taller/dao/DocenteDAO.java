package com.taller.dao;

import java.util.List;
import com.taller.modelo.Docente;

public interface DocenteDAO {

    void crear(Docente docente);
    Docente obtener(int id);
    List<Docente> listar();
    void actualizar(Docente docente);
    void eliminar(int id);
}