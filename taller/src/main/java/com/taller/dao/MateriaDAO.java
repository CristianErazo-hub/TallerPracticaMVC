package com.taller.dao;

import java.util.List;
import com.taller.modelo.Materia;

public interface MateriaDAO {

    void crear(Materia materia);

    Materia obtener(int id);

    List<Materia> listar();

    void actualizar(Materia materia);

    void eliminar(int id);
}