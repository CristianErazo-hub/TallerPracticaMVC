package com.taller.dao;

import java.util.List;
import com.taller.modelo.Grupo;

public interface GrupoDAO {

    void crear(Grupo grupo);

    Grupo obtener(int id);

    List<Grupo> listar();

    void actualizar(Grupo grupo);

    void eliminar(int id);
}