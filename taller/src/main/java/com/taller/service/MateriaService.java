package com.taller.service;

import com.taller.dao.MateriaDAO;
import com.taller.modelo.Materia;

import java.util.List;

public class MateriaService {

    private MateriaDAO materiaDAO;

    public MateriaService(MateriaDAO materiaDAO) {
        this.materiaDAO = materiaDAO;
    }

    public void crearMateria(Materia materia) {
        materiaDAO.crear(materia);
    }

    public List<Materia> listar() {
        return materiaDAO.listar();
    }
}