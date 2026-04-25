package com.taller.service;

import com.taller.dao.DocenteDAO;
import com.taller.modelo.Docente;

import java.util.List;

public class DocenteService {

    private DocenteDAO docenteDAO;

    public DocenteService(DocenteDAO docenteDAO) {
        this.docenteDAO = docenteDAO;
    }

    public void crearDocente(Docente docente) {
        docenteDAO.crear(docente);
    }

    public List<Docente> listar() {
        return docenteDAO.listar();
    }
}