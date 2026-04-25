package com.taller.service;

import com.taller.dao.GrupoDAO;
import com.taller.modelo.Grupo;

import java.util.List;

public class GrupoService {

    private GrupoDAO grupoDAO;

    public GrupoService(GrupoDAO grupoDAO) {
        this.grupoDAO = grupoDAO;
    }

    public void crearGrupo(Grupo grupo) {
        grupoDAO.crear(grupo);
    }

    public List<Grupo> listar() {
        return grupoDAO.listar();
    }
}